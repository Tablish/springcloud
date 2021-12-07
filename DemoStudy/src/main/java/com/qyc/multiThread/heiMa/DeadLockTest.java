package com.qyc.multiThread.heiMa;

public class DeadLockTest {

    private static Object a = new Object();
    private static Object b = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (a) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 第一层锁信息");
                    Thread.sleep(1000);
                    synchronized (b) {
                        System.out.println(Thread.currentThread().getName() + " 第二层锁信息");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();


        new Thread(() -> {
            synchronized (b) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 第一层锁信息");
                    Thread.sleep(500);
                    synchronized (a) {
                        System.out.println(Thread.currentThread().getName() + " 第二层锁信息");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();
    }

}
