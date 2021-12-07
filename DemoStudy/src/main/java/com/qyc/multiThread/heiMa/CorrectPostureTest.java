package com.qyc.multiThread.heiMa;

//使用sleep wait的正确姿势
public class CorrectPostureTest {
    static Boolean flag = false; //烟到了的标志
    static Object room = new Object();//对象

    public static void main(String[] args) throws InterruptedException {

        //线程1
        new Thread(() -> {
            synchronized (room) {
                if (!flag) {
                    System.out.println(Thread.currentThread().getName() + " 烟没到，我休息一会");
                    try {
//                        Thread.sleep(2000);//sleep不会释放room的锁，其他线程必须等找个临界区代码执行完才可以继续执行，也就是，是两个完全互斥的代码块
                        room.wait();//找个会释放锁，然后到waitSet中等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (flag) {
                    System.out.println(Thread.currentThread().getName() + " 干活");
                }
            }
        }, "t1").start();

        //其他线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized (room) {
                    System.out.println(Thread.currentThread().getName() + " 干活咯");
                }
            }, "其他线程").start();
        }

        /*t1 烟没到，我休息一会
        main 烟到咯
        t1 干活
        其他线程 干活咯
        其他线程 干活咯
        其他线程 干活咯
        其他线程 干活咯
        其他线程 干活咯*/

        //主线程
        Thread.sleep(1000);
        //逻辑1
//        flag = true; //1s后，flag = true，t1线程睡2s后，发现烟到了，就能继续干活了
//        System.out.println(Thread.currentThread().getName() + " 烟到咯");

        /*t1 烟没到，我休息一会
        其他线程 干活咯
        main 烟到咯
        其他线程 干活咯
        其他线程 干活咯
        其他线程 干活咯
        其他线程 干活咯*/
        //逻辑2：这种必须等拿到时间片的线程执行完，才能执行下面的代码，也就是t1，执行完也不会拿到烟继续干活
        synchronized (room) {
            flag = true;
            System.out.println(Thread.currentThread().getName() + " 烟到咯");
            room.notify();
        }

    }
}
