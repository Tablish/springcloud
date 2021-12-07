package com.qyc.designPattern.proxyDemo.demo1;

//代理角色（代理房东租房）：这里说成是 中介
public class Proxy implements Rent{
    //1 代理房东租房
    private Host host = new Host();

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void seeHouse() {
        System.out.println("中介带你看房");
    }

    public void contract() {
        System.out.println("中介签合同");
    }

    public void fee() {
        System.out.println("中介需要收费");
    }

    //租房的动作
    @Override
    public void rent() {
        host.rent();
        seeHouse();
        contract();
        fee();
    }
}
