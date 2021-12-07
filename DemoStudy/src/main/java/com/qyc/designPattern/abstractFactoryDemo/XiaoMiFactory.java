package com.qyc.designPattern.abstractFactoryDemo;

/**
 * 小米产品族
 */
public class XiaoMiFactory implements CreateFactory{
    @Override
    public IphoneFactory createPhone() {
        return new XiaoMiPhone();
    }

    @Override
    public IRouterFactory createRouter() {
        return new XiaoMiRouter();
    }
}
