package io.wonjin.functional.inter;

import java.util.function.Supplier;

public class NumberPrinter {
    public void print(Supplier<Integer> supplier) {
        System.out.println(supplier.get());
    }
}
