package com.qyc.multiThread.threadPoolTest;

import java.util.concurrent.CountDownLatch;

public class ClientDemo {
    private static int LATCH_SIZE = 5;
    private static CountDownLatch doneSignal;
    public static void main(String[] args) {
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(100, 200,
//                4, TimeUnit.SECONDS, new ArrayBlockingQueue(10), new ThreadPoolExecutor.AbortPolicy());

//        for (int i = 0;i < 10; i ++) {
//            threadPool.execute(new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    SynchronizedTest synchronizedTest = new SynchronizedTest();
//                    synchronizedTest.test();
//                }
//            }));
//        }


        final CountDownLatch begin = new CountDownLatch(1);

        for (int i = 0; i < 100; i++) {
            //final int NO = i + 1;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        begin.countDown();
                        begin.await();
                        //Thread.sleep((long)(Math.random() * 10000));
                        System.out.println(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        //end.countDown();
                    }
                }
            };
            //exec.submit(run);
        }

        begin.countDown();
    }
}
