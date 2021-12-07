package com.qyc.designPattern.abstractFactoryDemo;

public class Client {

    public static void main(String[] args) {

        //华为工厂调用
        HuaWeiFactory huaWeiFactory = new HuaWeiFactory();
        IphoneFactory huaWeiPhone = huaWeiFactory.createPhone();
        IRouterFactory huaWeiRouter = huaWeiFactory.createRouter();

        huaWeiPhone.call();
        huaWeiPhone.sendMsg();

        //小米工厂
        XiaoMiFactory xiaoMiFactory = new XiaoMiFactory();
        IphoneFactory xiaoMiFactoryPhone = xiaoMiFactory.createPhone();
        IRouterFactory xiaoMiFactoryRouter = xiaoMiFactory.createRouter();
        xiaoMiFactoryPhone.start();
        xiaoMiFactoryRouter.openWifi();
    }
}
