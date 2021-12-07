package com.qyc.designPattern.abstractFactoryDemo;

/**
 * 手机工厂
 */
public interface IphoneFactory {

    void start();

    void shutDown();

    void sendMsg();

    void call();
}
