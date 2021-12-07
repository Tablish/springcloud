package com.qyc.multiThread.systemStudy;

import java.util.concurrent.Callable;

public class CallableTest<String> implements Callable<String> {
    private int tickt = 10;
    @Override
    public String  call() throws Exception {
        String result;
        Thread.sleep(2000);
        while(tickt>0) {
            System.out.println(Thread.currentThread().getName() + ",票还剩余："+tickt);
            tickt--;
        }
        result=(String) "票已卖光";
        return result;
    }
}
