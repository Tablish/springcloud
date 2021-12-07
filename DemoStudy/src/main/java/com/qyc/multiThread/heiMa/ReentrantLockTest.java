package com.qyc.multiThread.heiMa;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 尝试获取锁");
            try {
                while (!lock.tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println(Thread.currentThread().getName() + " 获取不到锁");
                    return;
                }
                //System.out.println(Thread.currentThread().getName() + " 没获取到锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + " 获取不到锁");
                return;
            }
            System.out.println(Thread.currentThread().getName() + " 获取到了锁");
        }, "t1");

        lock.lock();
        System.out.println(Thread.currentThread().getName() + " 获得锁");
        t1.start();
        Thread.sleep(1000);
        lock.unlock();
    }
}
