package com.qyc.multiThread.heiMa;

import java.util.LinkedList;

//线程设计模式-生产者消费者-异步通信
public class MessageQueueTakeAndGet {

    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(2);
        //放消息线程
        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(() -> {

                queue.put(new Message(id, "消息-" + id));//放消息
            }).start();
        }

        //消费消息线程
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);//每隔1s就消费一次消息
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.take();
            }

        }).start();
    }
}

//队列类
class MessageQueue {

    private static LinkedList<Message> messageList = new LinkedList<Message>();//存放消息的容器

    private static int capacity;//队列容量

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    //拿消息
    public static Message take() {
        synchronized (messageList) {
            while (messageList.isEmpty()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 队列为空，等待生产者生产消息");
                    messageList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //一旦有消息就拿消息，从头部拿消息
            System.out.println(Thread.currentThread().getName() + " take message");
            Message message = messageList.removeFirst();
            messageList.notifyAll();//通知 因为存消息而被阻塞的线程 存消息
            return message;
        }
    }

    //放消息
    public static void put(Message message) {
        synchronized (messageList) {
            while (messageList.size() == capacity) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 队列已满，等待消费者消费消息");
                    messageList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //一旦可以放消息：从尾部放消息
            System.out.println(Thread.currentThread().getName() + " put message");
            messageList.addLast(message);
            messageList.notifyAll();//通知 因为拿消息而阻塞的线程 拿消息
        }
    }
}

//消息类
final class Message {

    private int id;
    private String content;

    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}