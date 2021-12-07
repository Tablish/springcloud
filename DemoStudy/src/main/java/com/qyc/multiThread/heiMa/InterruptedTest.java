package com.qyc.multiThread.heiMa;

import java.util.concurrent.TimeUnit;

public class InterruptedTest {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("sleeping ");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "=====" + Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        }, "t1");

        t1.start();
        try {
            //TimeUnit.SECONDS.sleep(1);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("interrupt...");
        t1.interrupt();
        System.out.println(Thread.currentThread().getName() + "=====" + t1.isInterrupted());//t1线程被打断，打断标记是false
    }
}
