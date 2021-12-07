package com.qyc.multiThread.futureTask;

import com.qyc.multiThread.future.Calc;

import java.util.concurrent.*;

public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Calc calc = new Calc();
        FutureTask<Integer> futureTask = new FutureTask<>(calc);
        //executorService.submit(futureTask);//用到了线程池
        futureTask.run();
        Integer integer = futureTask.get();
        System.out.println(integer);
        //Future<Integer> submit = executorService.submit(calc);
        //Integer integer = submit.get();
        //System.out.println(integer);
        //executorService.shutdown();
    }
}
