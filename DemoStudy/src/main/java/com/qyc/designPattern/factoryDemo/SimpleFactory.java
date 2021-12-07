package com.qyc.designPattern.factoryDemo;

/**
 * 简单工厂模式，又称静态工厂模式
 */
public class SimpleFactory {

    public static Car getCar(String carName) {
        if(carName.equals("wuling")) {
            return new WuLing();
        } else if (carName.equals("tesla")) {
            return new Tesla();
        } else {
            return null;
        }
    }
}
