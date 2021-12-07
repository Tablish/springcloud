package com.qyc.multiThread.heiMa;

public class RunnableTest {

    public static void main(String[] args) {

        //写法一
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " running");
            }
        };

        //写法二
        Runnable runnable2 = () -> System.out.println(Thread.currentThread().getName() + " running");

        Thread t1 = new Thread(runnable1, "t1");
        Thread t2 = new Thread(runnable2, "t2");
        t1.start();
        t2.start();

    }
}
