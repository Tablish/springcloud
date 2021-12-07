package com.qyc.multiThread.heiMa;

import org.omg.PortableServer.THREAD_POLICY_ID;

//守护线程：当一个进程中，非守护线程结束了，守护线程也会结束
public class DaeMonTest {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            while (true) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "守护线程结束...........");
                    break;
                } else {
                    System.out.println("非守护线程还没有结束................");
                }
            }
        });

        t.setDaemon(true);
        t.start();

        System.out.println("主线程结束...........");

    }
}
