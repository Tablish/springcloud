package com.qyc.multiThread.futureTask.callableAndFuture;

import java.util.concurrent.*;

public class CallableAndFutureClient {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableAndFuture callableDemo = new CallableAndFuture();
        Future<Integer> future = executorService.submit(callableDemo);//其实我觉得可以理解为，线程池去执行某一个规定好的逻辑（任务）
        executorService.shutdown(); //关闭线程池
        try {
            Thread.sleep(1000);//主线程睡眠1秒后，继续往下走
            System.out.println(Thread.currentThread().getName() + " 主线程继续往下走");
            if (future.get() == null) {
                System.out.println(Thread.currentThread().getName() + " future.get()-->" + future.get());
            } else {
                System.out.println(Thread.currentThread().getName() + " future.get()未获取到结果");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 主线程在执行完成");
    }
}
