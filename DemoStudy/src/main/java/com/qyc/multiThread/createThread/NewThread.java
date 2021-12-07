package com.qyc.multiThread.createThread;

public class NewThread extends Thread{

    @Override
    public void run() {
        System.out.println("myThread.run()");
    }

    public static void main(String[] args) {
        NewThread newThread1 = new NewThread();
        NewThread newThread2 = new NewThread();

        newThread1.start();
        newThread2.start();

//        newThread1.run();
//        newThread2.run();
    }

}
