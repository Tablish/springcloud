package com.qyc.designPattern.proxyDemo.demo2;

import com.qyc.designPattern.proxyDemo.demo1.Host;
import com.qyc.designPattern.proxyDemo.demo1.Rent;

public class Client {

    public static void main(String[] args) {
        try {
            //需要被代理的对象
            Host host = new Host();

            //代理类
            ProxyInvocationHandler pih = new ProxyInvocationHandler();
            pih.setTarget(host);
            Rent proxy = (Rent) pih.getProxy();

            //执行方法
            proxy.rent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
