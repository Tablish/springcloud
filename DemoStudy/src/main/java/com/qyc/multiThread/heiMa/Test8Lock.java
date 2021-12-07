package com.qyc.multiThread.heiMa;

public class Test8Lock {

    //    3  1s 12
    //    3  2 1s 1
    //    2  3 1s 1
    //因为方法c呢没有加synchronized，所以不需要获取对象锁，不存在互斥的情况出现，所以不会出现在1s后打印出来
    //锁住的是同一个对象，那么临界区代码块的执行顺序是互斥的
    public static void main(String[] args) {
        //下面两个方法锁住的都是this，谁调用我我就锁（占用了对象的锁）的是谁，很明显下面调用者都是demo
        NumberDemo demo = new NumberDemo();
        NumberDemo demo2 = new NumberDemo();
        Thread t1 = new Thread(() -> {
            //System.out.println(Thread.currentThread().getName() + " begin....");
            try {
                demo.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            //System.out.println(Thread.currentThread().getName() + " begin....");
            try {
                demo2.b();
                //demo.b(); 如果这里是demo，那么会出翔两种打印情况： 1s后 1 2； 2 1s后 1；但是如果这里是demo2.b()，那么就不会出现互斥的情况，线程2永远先打印出来，因为是并行执行的，所以不会出现1 在前面
                //并发，cpu某一个核心，轮流执行多个线程，因为时间分片的原因
                //并行，cpu多个核心，每个核心同时处理不同的线程，不会出现互斥的情况。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");

        Thread t3 = new Thread(() -> {
//            System.out.println(Thread.currentThread().getName() + " begin....");
            demo.c();
        }, "t3");


        t1.start();
        //t2.start();
        t3.start();
    }
}

class NumberDemo {
    public synchronized void a() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " 1");
    }

    public synchronized void b() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " 2");
    }

    public void c() {
        System.out.println(Thread.currentThread().getName() + " 3");
    }
}
