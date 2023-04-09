package io.wonjin.ngrinder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.IntStream;

public class UUIDGen {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        IntStream.rangeClosed(0, 2000000).forEach(i -> {
            set.add(UUID.randomUUID().toString().substring(0, 18));
        });

        System.out.println(set.size());
    }
}
