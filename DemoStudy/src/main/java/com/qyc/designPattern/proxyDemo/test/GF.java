package com.qyc.designPattern.proxyDemo.test;

public class GF implements Girl {
    @Override
    public void ppp() {
        System.out.println("和女朋友约会");
    }

    @Override
    public void aaa() {
        System.out.println("aaa");
    }
}
