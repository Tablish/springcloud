package com.qyc.multiThread.systemStudy;

/**
 * 三个线程公用一个run代码，公用一个ticket
 * 可能会造成线程安全问题，可以加入互斥锁
 */
public class MyThread2 implements Runnable{

    private int ticket = 5;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            if(ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + ticket--);
            }
        }
    }

    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        new Thread(myThread2).start();
        new Thread(myThread2).start();
        new Thread(myThread2).start();
        //new Thread()
    }
}