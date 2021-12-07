package com.qyc.multiThread.heiMa;

/*
RUNNABLE
TIMED_WAITING
*/
public class ThreadStateTest3 {

    public static void main(String[] args) {

        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " 被打断了");
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        System.out.println(Thread.currentThread().getName() + " running");
        t1.interrupt();
    }
}
