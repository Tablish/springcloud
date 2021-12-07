package com.qyc.multiThread.futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTaskForMultiClient {

    public static void main(String[] args) throws Exception {

        Callable<Integer> call = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                System.out.println("正在计算结果...");
                Thread.sleep(1000);
                return 1;
            }
        };

        FutureTask<Integer> task = new FutureTask<>(call);

        Thread thread = new Thread(task);
        thread.start();

        // do something
        System.out.println(" 干点别的...");

        Integer result = task.get();

        System.out.println("拿到的结果为：" + result);

    }
}
