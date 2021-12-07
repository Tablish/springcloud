package com.qyc.multiThread.heiMa;

public class ThreadSixStateTest {
    public static void main(String[] args) throws InterruptedException {
        //NEW
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                System.out.println("running...");
            }
        };

        //RUNNABLE
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                while (true) {
                }
            }
        };
        t2.start();

        //TERMINATED 结束：主线程睡眠了0.5s，此时打印t3状态时，t3已经执行完
        Thread t3 = new Thread("t3") {
            @Override
            public void run() {
                System.out.println("running...");
            }
        };
        t3.start();

        //TIMED WAITING
        Thread t4 = new Thread("t4") {
            @Override
            public void run() {
                synchronized(ThreadSixStateTest.class) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t4.start();

        //WAITING:because thread t2 while(true)
        Thread t5 = new Thread("t5") {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t5.start();

        //BLOCKING:because thread t4 has get this lock,it must wait util thread t4 has free this lock
        Thread t6 = new Thread("t6") {
            @Override
            public void run() {
                synchronized (ThreadSixStateTest.class) {
                    try {
                        Thread.sleep(200000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t6.start();

        //main thread has sleep 0.5s
        Thread.sleep(500);

        //print every thread's state
        System.out.println("t1 state======" + t1.getState()); //NEW
        System.out.println("t2 state======" + t2.getState()); //RUNNABLE???? 正常的运行啊
        System.out.println("t3 state======" + t3.getState()); //TERMINATED
        System.out.println("t4 state======" + t4.getState()); //TIMED WAITING
        System.out.println("t5 state======" + t5.getState()); //WAITING
        System.out.println("t6 state======" + t6.getState()); //BLOCKING
    }
}
