package com.qyc.multiThread.futureTask.callableAndFuture;

import java.util.concurrent.Callable;

public class CallableAndFuture implements Callable<Integer> {
    private int num = 0;
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " callable子线程开始计算啦");
        Thread.sleep(5000);
        for (int i = 0; i < 1000; i++) {
            num = num + 1;
        }
        System.out.println(Thread.currentThread().getName() + " callable子线程计算结束"); //主线程居然会等这一行代码执行完
        return num;
    }
}
