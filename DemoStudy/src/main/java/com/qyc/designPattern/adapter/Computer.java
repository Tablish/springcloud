package com.qyc.designPattern.adapter;

//客户端：上网
public class Computer {

    //不能直接上网，需要利用转换器
    public void wantNet(NetToUsb netToUsb) {
        //借助转换器连网线，上网

        //转换器的连接
        netToUsb.combine();
    }
}