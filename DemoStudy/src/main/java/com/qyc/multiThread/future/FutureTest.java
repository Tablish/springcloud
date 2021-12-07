package com.qyc.multiThread.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Integer>> futureList = new   ArrayList<>();

        //计算1000次 1-1亿的和
        for (int i = 0; i < 1000; i++) {
            //调度执行
            //executorService.execute(); 传一个实现了Runnable的接口，并且没有返回值
            futureList.add(executorService.submit(new Calc())); //传一个实现了Callable的类，并且返回future
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));

        for (int i = 0; i < 1000; i++) {
            try {
                Integer integer = futureList.get(i).get();
                System.out.println("第" + i + "个结果：" + integer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("耗时: " + (System.currentTimeMillis() - start));

    }
}
