package com.qyc.multiThread.systemStudy;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest<String> callableTest = new CallableTest<>();
        FutureTask<String> futureTask = new FutureTask<>(callableTest);
        System.out.println("买票结束");

        //睡眠后的操作是线程确实要做的事情，但是呢先提示了，操作结束，不关心是否真正的执行完成
        new Thread(futureTask).start();
        String result = futureTask.get();
        System.out.println(result);
    }
}
