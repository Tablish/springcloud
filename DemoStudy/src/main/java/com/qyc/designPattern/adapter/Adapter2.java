package com.qyc.designPattern.adapter;

public class Adapter2 implements NetToUsb{
    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void combine() {
        //需要连接网线
        adaptee.intenet();
    }
}
