package com.qyc.designPattern.proxyDemo.test;

public class Client {

    public static void main(String[] args) {
/*
        约会前的准备，准备tt
                和女朋友约会
        约会中，滚床单
        约会后，喝一杯枸杞水
                --------------------
        约会前的准备，准备tt
                aaa
        约会中，滚床单
        约会后，喝一杯枸杞水*/

        GF gf = new GF();

        ProxyClass proxyClass = new ProxyClass();

        proxyClass.setTarget(gf);

        Girl proxy = (Girl) proxyClass.getProxy();

        proxy.ppp();
        System.out.println("--------------------");
        proxy.aaa();

    }
}
