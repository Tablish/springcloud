package com.qyc.multiThread.heiMa;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable要配合FutureTask使用
 */
public class FutureTaskAndCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {//这里使用了lambda表达式
            System.out.println(Thread.currentThread().getName() + " running");
            Thread.sleep(2000);
            return 100;
        });

        Thread t = new Thread(futureTask, "t1");
        t.start();

        System.out.println(Thread.currentThread().getName() + " running");
        Integer integer = futureTask.get();//主线程执行到这里，会发生阻塞（等这个线程执行完）
        System.out.println("result" + integer);
    }
}
