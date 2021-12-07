package com.qyc.multiThread.heiMa;

//测试线程的六种状态

//拿到锁后wait，线程进入WAITING状态，notify、notifyAll、interrupt后，释放锁，和entryList里面的线程一起竞争，没竞争到就是MONITOR,竞争到了就是RUNNING状态
//某个synchronized执行完后，释放锁，其他线程重新竞争。


public class ThreadStateTest {

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 开始获取锁");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 开始获取锁");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();

        //主线程
        Thread.sleep(500);
        System.out.println(Thread.currentThread().getName() + " 唤醒其他线程");
        synchronized (lock) {
            lock.notifyAll();
        }
    }
}