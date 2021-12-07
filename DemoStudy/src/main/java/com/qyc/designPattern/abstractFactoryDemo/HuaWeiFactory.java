package com.qyc.designPattern.abstractFactoryDemo;

/**
 * 华为产品族
 */
public class HuaWeiFactory implements CreateFactory{
    @Override
    public IphoneFactory createPhone() {
        return new HuaWeiPhone();
    }

    @Override
    public IRouterFactory createRouter() {
        return new HuaWeiRouter();
    }
}
