package com.qyc.multiThread.heiMa;

public class TestFrame {
    public static void main(String[] args) {
        method1(10);
    }

    private static void method1(int x) {

        int y = x + 1;
        Object m = method2();
        System.out.println(m);
    }

    private static Object method2() {
        Object n = new Object();
        return n;
    }
}
