package io.wonjin.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    private Set<SocketChannel> clients = new HashSet<>();

    public void run() {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(50770));
            serverSocketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("Server Ready...");

            ByteBuffer inputBuffer = ByteBuffer.allocate(1024);
            ByteBuffer outputBuffer = ByteBuffer.allocate(1024);

            while (true) {
                selector.select();

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (key.isAcceptable()) {
                        System.out.println("클라이언트 접속");
                        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                        SocketChannel clientSocket = serverChannel.accept();

                        clientSocket.configureBlocking(false);

                        clients.add(clientSocket);

                        clientSocket.write(ByteBuffer.wrap("아이디를 입력해주세요 : ".getBytes()));

                        clientSocket.register(selector, SelectionKey.OP_READ, new ClientInfo());
                    } else if (key.isReadable()) {
                        SocketChannel readSocket = (SocketChannel) key.channel();
                        ClientInfo clientInfo = (ClientInfo) key.attachment();

                        try {
                            readSocket.read(inputBuffer);
                        } catch (Exception e) {
                            key.cancel();
                            clients.remove(readSocket);

                            String end = clientInfo.getId() + "님이 연결 종료되었습니다.";
                            System.out.println(end);

                            outputBuffer.put(end.getBytes());
                            for (SocketChannel socketChannel : clients) {
                                if (!readSocket.equals(socketChannel)) {
                                    outputBuffer.flip();
                                    socketChannel.write(outputBuffer);
                                }
                            }
                            outputBuffer.clear();
                            continue;
                        }

                        if (!clientInfo.hasId()) {
                            inputBuffer.limit(inputBuffer.position() - 2);
                            inputBuffer.position(0);
                            byte[] bytes = new byte[inputBuffer.limit()];
                            inputBuffer.get(bytes);
                            clientInfo.setId(new String(bytes));

                            String enter = clientInfo.getId() + "님이 입장하셨습니다.";
                            System.out.println(enter);

                            outputBuffer.put(enter.getBytes());

                            for (SocketChannel socketChannel : clients) {
                                outputBuffer.flip();
                                socketChannel.write(outputBuffer);
                            }

                            inputBuffer.clear();
                            outputBuffer.clear();
                            continue;
                        }

                        inputBuffer.flip();
                        outputBuffer.put((clientInfo.getId() + " : ").getBytes());
                        outputBuffer.put(inputBuffer);
                        outputBuffer.flip();

                        for (SocketChannel socketChannel : clients) {
                            if (!readSocket.equals(socketChannel)) {
                                socketChannel.write(outputBuffer);
                                outputBuffer.flip();
                            }
                        }

                        inputBuffer.clear();
                        outputBuffer.clear();
                    }
                }
             }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
