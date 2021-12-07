package com.qyc.multiThread.heiMa;

import java.util.ArrayList;

public class TestSafeThread {
    static int THREAD_NUMBER = 2;
    static int LOOP_NUMBER = 200;

    public static void main(String[] args) {
        ThreadUnSafe threadUnSafe = new ThreadUnSafe();//线程不安全
        ThreadSafe threadSafe = new ThreadSafe();//线程安全的，虽然是一个对象调用的，但是只要调用一次method1()，就会生成一个新的list，这种情况下，list不是共享的资源
        ThreadSafeSubClass threadSafeSubClass = new ThreadSafeSubClass();
        for (int i = 0; i < THREAD_NUMBER; i++) {
            new Thread(() -> {
                //threadUnSafe.method1(LOOP_NUMBER);
                //threadSafe.method1(LOOP_NUMBER);
                threadSafeSubClass.method1(LOOP_NUMBER);
            }).start();
        }
    }
}

class ThreadUnSafe {
    ArrayList<String> list = new ArrayList<String>(); //对于两个线程来说，这个list是共享的，共享的肯定是线程不安全的

    public void method1(int loopNumber) {
        for (int i = 0; i < loopNumber; i++) {
            method2();
            method3();
        }
    }

    private void method2() {
        list.add("1");
    }

    private void method3() {
        list.remove(0);
    }
}

class ThreadSafe {
    public void method1(int loopNumber) {
        System.out.println("method1 " + Thread.currentThread().getName());
        ArrayList<String> list = new ArrayList<String>();//某个线程创建了list传给method3，method3又新建一个线程并且用到了list，导致这个list被多个线程共享，所以不安全
        for (int i = 0; i < loopNumber; i++) {
            method2(list);
            method3(list);
        }
    }

    public void method2(ArrayList<String> list) {
        list.add("1");
    }

    public void method3(ArrayList<String> list) {
        list.remove(0);
    }
}

class ThreadSafeSubClass extends ThreadSafe {
    @Override
    public void method3(ArrayList<String> list) {
        new Thread(() -> {
            System.out.println("method3 " + Thread.currentThread().getName());
            list.remove(0);
        }).start();

    }
}