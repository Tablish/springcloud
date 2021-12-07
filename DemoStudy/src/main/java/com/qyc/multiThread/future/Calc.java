package com.qyc.multiThread.future;

import java.util.concurrent.Callable;

public class Calc implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return cal(10000);
    }

    private Integer cal(int count) {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
