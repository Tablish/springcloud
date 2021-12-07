package com.qyc.multiThread.heiMa;

//使用sleep wait的正确姿势
public class CorrectPostureTest2 {
    static Boolean flag = false; //烟到了的标志
    static Boolean flag2 = false; //烟到了的标志
    static Object room = new Object();//对象

    public static void main(String[] args) throws InterruptedException {

        //线程1
        new Thread(() -> {
            synchronized (room) {
                while (!flag) {
                    System.out.println(Thread.currentThread().getName() + " 烟没到，我休息一会");
                    try {
//                        Thread.sleep(2000);//sleep不会释放room的锁，其他线程必须等找个临界区代码执行完才可以继续执行，也就是，是两个完全互斥的代码块
                        room.wait();//找个会释放锁，然后到waitSet中等待;使用notifyAll之后呢，t1也被叫醒，然后执行下一行代码，发现下面没有代码可以执行了，而且这里是个while，只能再次执行while，发现还是没有
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (flag) {
                    System.out.println(Thread.currentThread().getName() + " 干活");
                } else {
                    System.out.println(Thread.currentThread().getName() + " 没干成活");
                }
            }
        }, "t1").start();

        //线程t2
        new Thread(() -> {
            synchronized (room) {
                if (!flag2) {
                    System.out.println(Thread.currentThread().getName() + " 外卖没到，我休息一会");
                    try {
//                        Thread.sleep(2000);//sleep不会释放room的锁，其他线程必须等找个临界区代码执行完才可以继续执行，也就是，是两个完全互斥的代码块
                        room.wait();//找个会释放锁，然后到waitSet中等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (flag2) {
                    System.out.println(Thread.currentThread().getName() + " 干活");
                }
            }
        }, "t2").start();

        //主线程
        Thread.sleep(1000);
        synchronized (room) {
            flag2 = true;
            System.out.println(Thread.currentThread().getName() + " 外卖到咯");
            room.notifyAll();
        }
    }
}
