package com.qyc.multiThread.heiMa;

public class WaitAndNotifyTest {

    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

//        try {
//            lock.wait();//必须先获取对象的锁，才能wait；就是对象的owner先有一个对象，才能wait，wait后进入waitSet
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " 执行。。。");
                try {
                    lock.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 其他逻辑。。。");
            }
        }, "t1").start();

//        new Thread(() -> {
//            synchronized (lock) {
//                System.out.println(Thread.currentThread().getName() + " 执行。。。");
//                try {
//                    lock.wait(); //进入waitSet（WAITING），等到这把锁notify，将WAITING -> RUNNABLE,重新有机会获取时间片;;;如果被唤醒的是当前线程，会从这个逻辑下面继续执行
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + " 其他逻辑。。。");
//            }
//        }, "t2").start();

        Thread.sleep(500); //提前唤醒线程
        synchronized (lock) {
            //lock.notify();
            lock.notifyAll();
        }
    }
}
