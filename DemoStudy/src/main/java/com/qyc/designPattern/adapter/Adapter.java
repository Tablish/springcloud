package com.qyc.designPattern.adapter;

//转接口:1 连接网线 2 连接电脑
public class Adapter extends Adaptee implements NetToUsb{

    @Override
    public void combine() {
        //调用了网线的方法：上网，此时都通了
        super.intenet();
    }
}
