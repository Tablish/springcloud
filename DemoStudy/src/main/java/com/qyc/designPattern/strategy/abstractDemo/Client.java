package com.qyc.designPattern.strategy.abstractDemo;

public class Client {
    public static void main(String[] args) {

        String opt = "add";

        Handler handler = Factory.getHandler(opt);

        handler.doSth();
    }
}
