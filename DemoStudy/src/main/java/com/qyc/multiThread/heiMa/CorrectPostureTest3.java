package com.qyc.multiThread.heiMa;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import static com.qyc.multiThread.heiMa.Mailbox.createGuarded;

/**
 * 本类两个作用
 * 1 两个线程：一个线程获取另外一个线程的执行结果
 * 2 保护性暂停扩展-解耦等待与生产
 */
public class CorrectPostureTest3 {
    public static void main(String[] args) throws InterruptedException {
        //作用1
//        GuardedObject response = new GuardedObject();
//        //获取结果线程
//        new Thread(() -> {
//            System.out.println(Thread.currentThread().getName() + "===开始获取值");
//            System.out.println(response.get());
//        }, "t1").start();
//
//        //赋值线程
//        new Thread(() -> {
//            try {
//                System.out.println(Thread.currentThread().getName() + "===开始赋值");
//                //List<String> download = DownLoader.download();
//                Thread.sleep(2000);
//                response.set(22);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }, "t2").start();

        //作用2 保护性暂停扩展-解耦等待与生产
        //people拿信
        for (int i = 0; i < 3; i++) {
            new People().start();
        }
        Thread.sleep(1000);
        //postman送信
        for (Integer id : Mailbox.getIds()) {
            new Postman(id, "内容" + id).start();
        }
    }
}

//神奇的是：由静态方法创建的对象，居然是同一个对象。。这里就可以用synchronized
class People extends Thread {
    @Override
    public void run() {
        GuardedObject guarded = Mailbox.createGuarded();
        System.out.println("people " + guarded  + " 开始收信：" + guarded.getId());
        //System.out.println(Thread.currentThread().getName() + "-People" + " 开始收信：" + guarded.getId());
        Object mail = guarded.get(5000);
        System.out.println(Thread.currentThread().getName() + "-People" + " 收到信id：" + guarded.getId() + ";收到信内容：" +mail);
        //System.out.println("收到信内容：" + mail);
    }
}

class Postman extends Thread {
    private int id;//信箱id
    private String content;//信的内容

    public Postman(int id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public void run() {
        GuardedObject guarded = Mailbox.getGuardedObject(id);
        System.out.println();
        System.out.println("postman " + guarded + " " + Thread.currentThread().getName() + "-postman" + " 送信id：" + guarded.getId() + ";信内容：" + content);

        guarded.set(content);
    }
}

class Mailbox {

    //信箱：id -> 信对象
    private static Hashtable<Integer, GuardedObject> mailboxes = new Hashtable<Integer, GuardedObject>();

    private static int ids = 0;

    static synchronized int generateId() {
        return ids++;
    }

    //信箱创建信对象
    public static GuardedObject createGuarded() {
        GuardedObject guardedObject = new GuardedObject(generateId());
        mailboxes.put(guardedObject.getId(), guardedObject);
        return guardedObject;
    }

    //信箱拿信
    public static GuardedObject getGuardedObject(int id) {
        return mailboxes.remove(id);
    }

    //信箱拿信
//    public GuardedObject getGuarded(int id) {
//        return mailboxes.remove(id);
//    }

    public static Set<Integer> getIds() {
        return mailboxes.keySet();
    }
}

class GuardedObject {
    //作用2：当作信的对象
    private int id;

    public GuardedObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //作用1
    private Object response;

    //获取
    public Object get(long timeout) {
        synchronized (this) {
            long startTime = System.currentTimeMillis();//循环开始时间
            long passedTime = 0;//已经等待了的时间
            while (response == null) {
                long needWaitTime = timeout - passedTime; //还需要等待时间
                if (needWaitTime <= 0) {
                    break;
                }
                try {
                    this.wait(needWaitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passedTime = System.currentTimeMillis() - startTime;
            }
            return response;
        }
    }

    //赋值
    public void set(Object response) {
        synchronized (this) {
            this.response = response;
            this.notifyAll();//此时可以唤醒t1线程
        }
    }
}