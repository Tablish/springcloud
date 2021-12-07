package com.qyc.designPattern.abstractFactoryDemo;

public class XiaoMiPhone implements IphoneFactory {

    @Override
    public void start() {
        System.out.println("小米手机开机");
    }

    @Override
    public void shutDown() {
        System.out.println("小米手机关机");
    }

    @Override
    public void sendMsg() {
        System.out.println("小米手机发送信息");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }
}
