package io.wonjin;

import io.wonjin.nio.NIOServer;
import io.wonjin.old.OIOServer;

public class Main {
    public static void main(String[] args) {
//        new OIOServer().run();
        new NIOServer().run();
    }
}