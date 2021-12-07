package com.qyc.designPattern.proxyDemo.demo1;

//被代理的角色：这里是房东
public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("我是房东，我要租赁房子啦");
    }
}
