package com.qyc.multiThread.heiMa;

public class YieldAndPriorityTest {


    public static void main(String[] args) {
        /* test(); */

        aaa aaa = new aaa();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                int count = 0;
                for (; ; ) {
                    System.out.println("t1      " + count++);
                }
            }
        };


        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                int count = 0;
                for (; ; ) {
                    //Thread.yield();
                    System.out.println("                    t2 " + count++);
                }
            }
        };

        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r2, "t2");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }

    //内部类也要静态的
   static class aaa{

   }
}
