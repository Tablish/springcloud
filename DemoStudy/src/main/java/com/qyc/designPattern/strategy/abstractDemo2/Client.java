package com.qyc.designPattern.strategy.abstractDemo2;

public class Client {
    public static void main(String[] args) {

        String opt = "add";

        AbstractHandler handler = Factory.getHandler(opt);

        handler.AAA();

        //原始方法
        if("add".equals(opt)) {
            //


            ///
        } else if("multiply".equals(opt)) {

            //


            //
        }
    }
}