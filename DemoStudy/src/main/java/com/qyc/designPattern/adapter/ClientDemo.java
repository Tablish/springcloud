package com.qyc.designPattern.adapter;

//小伙子想上网：电脑 转接头 网线；
//思路：电脑上网方法中，传个转接头，转接头找到了网线，此时三者都通了，网也连上了
public class ClientDemo {

    public static void main(String[] args) {
        //第一种方法：单继承
        //1 电脑
        Computer computer = new Computer();

        //2 具体的转接口
        Adapter adapter = new Adapter();
        computer.wantNet(adapter);

        //第二种方法：
        Adaptee adaptee = new Adaptee();
        Adapter2 adapter2 = new Adapter2(adaptee);
        computer.wantNet(adapter2);
    }
}
