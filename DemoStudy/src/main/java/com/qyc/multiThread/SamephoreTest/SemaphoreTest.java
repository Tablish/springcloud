package com.qyc.multiThread.SamephoreTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;

    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("这是一个接口请求");
                        s.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        threadPool.shutdown();
    }
}
