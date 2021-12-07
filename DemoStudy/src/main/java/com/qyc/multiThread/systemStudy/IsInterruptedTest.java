package com.qyc.multiThread.systemStudy;

/**
 * isInterrupted 如果程序中断了，返回true，反之，false
 * 中断后，调用sleep，会走catch代码块
 */
public class IsInterruptedTest extends Object{

    public static void main(String[] args) {
        Thread t = Thread.currentThread();

        System.out.println("Point A: t.isInterrupted=" + t.isInterrupted());
        t.interrupt();
        System.out.println("Point B: t.isInterrupted=" + t.isInterrupted());

        try{
            Thread.sleep(2000);
            System.out.println("was Not interrupted");
        } catch (InterruptedException e) {
            System.out.println("was interrupted");
        }

        //抛出异常后，会清除中断标志，这里会返回false
        System.out.println("Point D：t.isInterrupted="+ t.isInterrupted());
    }
}
