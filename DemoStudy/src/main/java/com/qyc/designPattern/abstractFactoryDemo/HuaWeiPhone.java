package com.qyc.designPattern.abstractFactoryDemo;

public class HuaWeiPhone implements IphoneFactory {

    @Override
    public void start() {
        System.out.println("华为手机开机");
    }

    @Override
    public void shutDown() {
        System.out.println("华为手机关机");
    }

    @Override
    public void sendMsg() {
        System.out.println("华为手机发送信息");
    }

    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }
}
