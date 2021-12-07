package com.qyc.multiThread.heiMa;

public class JoinTest {
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                count = 10;
            }
        };

        Thread t1 = new Thread(r);
        t1.start();
        t1.join();//main线程执行到这里，会等待t1线程执行完run方法体，才会往下执行
        System.out.println(count);

    }

}
