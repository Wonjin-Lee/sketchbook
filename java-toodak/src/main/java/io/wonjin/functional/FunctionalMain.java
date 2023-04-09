package io.wonjin.functional;

import io.wonjin.functional.inter.NumberPrinter;
import io.wonjin.functional.inter.RandomNumberSupplier;

import java.security.SecureRandom;
import java.util.function.Supplier;

public class FunctionalMain {
    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter();

        RandomNumberSupplier supplier = () -> new SecureRandom().nextInt(10);

        numberPrinter.print(supplier);
    }
}
