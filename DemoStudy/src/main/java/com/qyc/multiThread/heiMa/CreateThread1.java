package com.qyc.multiThread.heiMa;

public class CreateThread1 {

    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " running");
            }
        };
        t.setName("t1");
        t.start();

        System.out.println(Thread.currentThread().getName() + " running");
    }
}
