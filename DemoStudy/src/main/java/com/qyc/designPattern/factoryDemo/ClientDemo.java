package com.qyc.designPattern.factoryDemo;

public class ClientDemo {

    public static void main(String[] args) {
        //静态工厂（简单工厂模式）
        Car wuling = SimpleFactory.getCar("wuling");
        Car tesla = SimpleFactory.getCar("tesla");
        wuling.carName();
        tesla.carName();

        //工厂方法模式
        WuLingFactory wuLingFactory = new WuLingFactory();
        TeslaFactory teslaFactory = new TeslaFactory();
        Car wuLingFactoryCar = wuLingFactory.getCar();
        Car teslaFactoryCar = teslaFactory.getCar();
        wuLingFactoryCar.carName();
        teslaFactoryCar.carName();
    }
}
