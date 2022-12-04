package io.wonjin.old;


import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OIOServer {
    private static final int PORT = 50770;
    private static final int THREAD_COUNT = 10;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    public void run() {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(true);
            serverSocketChannel.bind(new InetSocketAddress(PORT));

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                System.out.println("Connected : " + socketChannel.getRemoteAddress());

                threadPool.execute(new ConnectionWrap(socketChannel));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

@RequiredArgsConstructor
class ConnectionWrap implements Runnable {

    private final SocketChannel socketChannel;

    @Override
    public void run() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        Charset charset = Charset.forName("UTF-8");

        try {
            socketChannel.read(byteBuffer);
            byteBuffer.flip();
            String receivedData = charset.decode(byteBuffer).toString();
            System.out.println("Received Data : " + receivedData);

            byteBuffer = charset.encode("Hello, My Client!");

            socketChannel.write(byteBuffer);
            System.out.println("Sending Success!");

            if (socketChannel.isOpen()) {
                socketChannel.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
