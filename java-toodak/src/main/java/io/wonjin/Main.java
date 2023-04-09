package io.wonjin;

import io.wonjin.functional.inter.MyLambdaFunction;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int result = ((MyLambdaFunction) (a, b) -> a > b ? a : b).max(1, 5);

        System.out.println(result);
    }
}