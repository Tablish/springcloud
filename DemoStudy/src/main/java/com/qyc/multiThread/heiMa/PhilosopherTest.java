package com.qyc.multiThread.heiMa;

//死锁-五个哲学家吃饭问题
public class PhilosopherTest {

    public static void main(String[] args) {

        Chopsticks c1 = new Chopsticks("1");
        Chopsticks c2 = new Chopsticks("2");
        Chopsticks c3 = new Chopsticks("3");
        Chopsticks c4 = new Chopsticks("4");
        Chopsticks c5 = new Chopsticks("5");

        new Philosopher("苏格拉底", c1, c2).start();
        new Philosopher("亚里士多德", c2, c3).start();
        new Philosopher("孔子", c3, c4).start();
        new Philosopher("庄子", c4, c5).start();
        new Philosopher("阿基米德", c5, c1).start();
    }
}

class Philosopher extends Thread {

    private Chopsticks left;
    private Chopsticks right;

    public Philosopher(String name, Chopsticks left, Chopsticks right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (left) {
                synchronized (right) {
                    eat();
                }
            }
        }
    }

    //同事拿到了两只筷子，才能吃饭
    public void eat() {
        System.out.println(Thread.currentThread().getName() + " 吃饭");
    }
}


class Chopsticks {

    private String name;

    public Chopsticks(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Chopsticks{" +
                "name='" + name + '\'' +
                '}';
    }
}
