package com.qyc.multiThread.heiMa;

public class LiveLockTest {

    private static int count = 10;

    public static void main(String[] args) {

        //减到0就结束
        new Thread(() -> {
            while (count > 0) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                System.out.println(Thread.currentThread().getName() + " " + count);
            }
        }, "t1").start();

        //加到20就结束
        new Thread(() -> {
            while (count < 20) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                System.out.println(Thread.currentThread().getName() + " " + count);
            }
        }, "t2").start();
    }
}
