package com.qyc.designPattern.abstractFactoryDemo;

public class HuaWeiRouter implements IRouterFactory {
    @Override
    public void start() {
        System.out.println("华为路由器开机");
    }

    @Override
    public void shutDown() {
        System.out.println("华为路由器关机");
    }

    @Override
    public void setting() {
        System.out.println("华为路由器设置");

    }

    @Override
    public void openWifi() {
        System.out.println("华为路由器打开无线网");
    }
}
