package com.qyc.multiThread.heiMa;

//t1 t2 交替执行
public class JiaoTiTest {

    public static void main(String[] args) {
        new Thread(() -> {
            //for (int i = 0; i < 10; i++) {
                while(true) {
                    System.out.println(Thread.currentThread().getName() + " ");
                }
            //}
        }, "t1").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }, "t2").start();
    }
}
