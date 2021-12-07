package com.qyc.multiThread.systemStudy;

/**
 * 线程中断,会进入catch代码块
 */
public class SleepInterrupt extends Object implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("in run() - about to sleep for 20 seconds");
            Thread.sleep(20000);
            System.out.println("in run() - woke up");
        } catch (InterruptedException e) {
            System.out.println("in run() - interrupted while sleeping");
            //e.printStackTrace();
            //return;
        }
        System.out.println("in run() - leaving normally");
    }

    public static void main(String[] args) {
        SleepInterrupt interrupt = new SleepInterrupt();
        Thread thread = new Thread(interrupt);
        thread.start();

        //主线程休眠2秒，从而确保刚才启动的线程有机会执行一段时间
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("in main() - interrupting other thread");
        thread.interrupt();
        System.out.println("in main() - leaving");
    }
}
