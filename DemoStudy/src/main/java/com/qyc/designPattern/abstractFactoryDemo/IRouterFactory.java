package com.qyc.designPattern.abstractFactoryDemo;

/**
 * 路由器工厂
 */
public interface IRouterFactory {

    void start();

    void shutDown();

    void setting();

    void openWifi();
}
