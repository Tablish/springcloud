package com.qyc.multiThread.heiMa;

import java.util.Random;
/*
模拟转账
因为在两个线程中，都要读取this和target，所以这里有两个共享变量，所以单纯的锁住this是不行，此时target还是共享的变量，所以必须要锁住两者的共同点，Account类
买票demo中，只有一个共享变量。
*/
public class TransferTest {
    public static void main(String[] args) throws InterruptedException {
        //创建两个账户
        Account accountA = new Account(1000);
        Account accountB = new Account(1000);

        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                accountA.transfer(accountB, getRandom());
            }
        }, "t1");

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                accountB.transfer(accountA, getRandom());
            }
        }, "t2");

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println("两个账户总额" + (accountA.getAmount() + accountB.getAmount()));
    }

    public static int getRandom() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
}

class Account {
    private int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    /**
     * 转账
     *
     * @param target 到钱的账户
     * @param amount 转账金额
     */
    public void transfer(Account target, int amount) {
        //因为在两个线程中，都要读取this和target，所以这里有两个共享变量，所以单纯的锁住this是不行，此时target还是共享的变量，所以必须要锁住两者的共同点，Account类
        synchronized (Account.class) {
            if (this.amount >= amount) {
                //account.amount = account.amount + amount;//被转的账户 加钱
                //this.amount = this.amount - amount;//主动发起转账的账户 扣钱
                target.setAmount(target.getAmount() + amount);
                this.setAmount(this.getAmount() - amount);
            }
        }
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}