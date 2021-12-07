package com.qyc.multiThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;

//每齐20个。执行一次 cyclicBarrier里面的代码
public class CyclicBarrierTest2 {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(20, () -> System.out.println("满人了")); //每满20会执行
        for (int i = 0; i < 30; i++) {
            int count = i + 1;
            new Thread(() -> {
                try {
                    System.out.println("=== " + count);
                    barrier.await(); //这边阻塞，每到满20会继续执行下去
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        if(1 == 2) {
            barrier.reset();
        }
        System.out.println("----------------------------");
    }
}
