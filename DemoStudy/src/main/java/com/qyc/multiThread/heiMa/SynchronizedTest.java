package com.qyc.multiThread.heiMa;

public class SynchronizedTest {

    public static void main(String[] args) {
//        Room room = new Room();
//        room.increase();
//        room.decrease();
//        System.out.println(Thread.currentThread().getName() + " " + room.getCount());
//        room.test3();
//        room.test4();


        ((SynchronizedTest)null).Print();
        //SynchronizedTest.Print();

    }

    private void Print(){
        System.out.println("Print()");
    }
}

class Room {

    int count = 0;

    //    public void increase() {
//        synchronized (this) {
//            for (int i = 0; i < 5000; i++) {
//                count++;
//            }
//        }
//    }
    //等价于
    public synchronized void increase() {
        for (int i = 0; i < 5000; i++) {
            count++;
        }
    }


    public void decrease() {
        synchronized (this) {
            for (int i = 0; i < 5000; i++) {
                count--;
            }
        }
    }

    public int getCount() {
        synchronized (this) {
            return count;
        }
    }

    public static void test1() {
        synchronized (SynchronizedTest.class) {
            System.out.println("hello world");
        }
    }

    //test1 和 test2 其实是等价的
    public synchronized static void test2() {
        System.out.println("hello world");
    }

    public void test3() {
        System.out.println("this====" + this);
    }

    public void test4() {
        System.out.println("this====" + this);
    }


}