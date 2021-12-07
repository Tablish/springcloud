package com.qyc.multiThread.heiMa;

public class InterruptedTest2 {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            while(true) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("被打断了");
                    return;
                }
                //System.out.println("被打断了");
            }
        }, "t1");

        t.start();
        System.out.println("interrupt...");
        t.interrupt();
    }
}
