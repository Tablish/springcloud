package com.qyc.multiThread.heiMa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

//卖票
public class SellTicket {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        //初始化总票数
        TicketWindow ticketWindow = new TicketWindow(1000);

        List<Thread> threadList = new ArrayList<Thread>();//这里是在线程外面
        List<Integer> sellSum = new Vector<>();//线程共享，所以要考虑线程安全问题

        //CopyOnWriteArrayList<Integer> sellSum = new CopyOnWriteArrayList<Integer>();//

        //创建5000个线程：每个线程执行同样的操作--买票
        for (int i = 0; i < 5000; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //买票
                int sell = ticketWindow.sell(getRandomNum(5));

                //记录每次卖的票
                sellSum.add(sell);

            });
            //保存每个线程
            threadList.add(thread);
            thread.start();
        }

        //等待 每个买票的线程都执行结束
        for (Thread thread : threadList) {
            thread.join();
        }

        System.out.println("剩余多少门票  " + ticketWindow.getCount());
        System.out.println("卖了多少门票 " + sellSum.stream().mapToInt(i -> i).sum());
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / 1000);
    }


    public static int getRandomNum(int amount) {
        Random random = new Random();
        return random.nextInt(amount) + 1;
    }
}

class TicketWindow {
    private int count;

    public TicketWindow(int count) {
        this.count = count;
    }

    //买票
    public synchronized int sell(int sellNumber) {
        if (count >= sellNumber) {
            count = count - sellNumber;
            return sellNumber;
        } else {
            return 0;
        }
    }

    //剩余票数
    public int getCount() {
        return count;
    }
}
