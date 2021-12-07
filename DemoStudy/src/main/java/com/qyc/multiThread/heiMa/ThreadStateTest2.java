package com.qyc.multiThread.heiMa;

/*
RUNNABLE
TIMED_WAITING
*/
public class ThreadStateTest2 {

    public static void main(String[] args) {

        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println("running ...");
            }
        };
        //System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());

        //说明还没走到t1线程，一直还是main线程在执行，于是让主线程等待0.5s，目的时让t1线程获取cpu调度器的时间片，重新获取t1线程的状态
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.getState());
    }
}
