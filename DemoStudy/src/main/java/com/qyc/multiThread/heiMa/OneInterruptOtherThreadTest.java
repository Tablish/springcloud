package com.qyc.multiThread.heiMa;

/**
 * 一个线程优雅的停掉另外一个线程：被停掉的线程可以处理后世，而不是暴力的被干掉
 */
public class OneInterruptOtherThreadTest {
    public static void main(String[] args) throws InterruptedException {
        TwpPhaseTermination twpPhaseTermination = new TwpPhaseTermination();
        twpPhaseTermination.start();
        //3s后，需要打算这个监控程序
        Thread.sleep(2500);
        twpPhaseTermination.stop();
    }
}

//两阶段终止模式
class TwpPhaseTermination {
    private Thread monitor;

    //开启监控线程
    public void start() {
        monitor = new Thread(() -> {
            //每隔2s执行一次监控逻辑
            while (true) {
                Thread currentThread = Thread.currentThread();
                if (currentThread.isInterrupted()) {
                    //被打断了，需要料理后世
                    System.out.println("料理后事，比如恢复状态啊，数据的事务操作啊 and so on...");
                    break;
                }
                try {
                    Thread.sleep(2000); //休眠2s后执行监控逻辑    打断1
                    System.out.println("记录信息。。。" + System.currentTimeMillis()); //执行监控逻辑     打断2
                } catch (InterruptedException e) {
                    currentThread.interrupt();//如果是打断1 处被打断，走到catch，需要重置打断状态，下个循环时，满足条件，break；
                    e.printStackTrace();
                }
            }
        });

        monitor.start();
    }

    public void stop() {
        monitor.interrupt();
    }
}
