package com.qyc.multiThread.heiMa;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            System.out.println("start......interrupted:" + Thread.currentThread().isInterrupted());//一个没被打断的线程打断标志是 false
            LockSupport.park();
            //isInterrupted 会返回打断标志，但是不会重置打断标记（false）
            //interrupted   会返回打断标志，但是  会重置打断标记（false）
            System.out.println("interrupted:" + Thread.currentThread().isInterrupted());//true
            System.out.println("interrupted:" + Thread.interrupted());//重置为false，再次遇到LockSupport.park()时，不会继续执行了
            System.out.println("end......");

            LockSupport.park();//如果当前的打断标记是 true，这个api就会失效
            System.out.println("last but not least......");
        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();//打断了LockSupport.park()的打断：打断了你的打断，负负得正，哈哈~~
    }
}
