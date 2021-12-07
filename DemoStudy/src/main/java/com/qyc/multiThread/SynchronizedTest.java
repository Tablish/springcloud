package com.qyc.multiThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SynchronizedTest {

    public static void main(String[] args) {

    }

    public void test() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
