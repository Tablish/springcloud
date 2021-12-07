package com.qyc.designPattern.abstractFactoryDemo;

/**
 * 产品族
 */
public interface CreateFactory {

    IphoneFactory createPhone();

    IRouterFactory createRouter();
}
