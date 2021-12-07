package com.qyc.multiThread.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileAtomicTest {
    public static volatile AtomicInteger num = new AtomicInteger(0);
    public static void increase() {
        num.incrementAndGet();
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(num);
    }

}
