package com.qyc.multiThread.futureTask.callableAndFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CallableAndFutureTaskClient {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableAndFuture callable = new CallableAndFuture();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        executorService.submit(futureTask);
        executorService.shutdown();

        try {
            Thread.sleep(1000);//主线程睡眠1秒后，继续往下走
            System.out.println(Thread.currentThread().getName() + " 主线程继续往下走");
            if (futureTask.get() == null) {
                System.out.println(Thread.currentThread().getName() + " future.get()-->" + futureTask.get());
            } else {
                System.out.println(Thread.currentThread().getName() + " future.get()未获取到结果");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 主线程在执行完成");
    }
}
