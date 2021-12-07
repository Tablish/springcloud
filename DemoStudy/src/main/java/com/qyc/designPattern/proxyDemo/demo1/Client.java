package com.qyc.designPattern.proxyDemo.demo1;

//客户：需要租房
public class Client {

    public static void main(String[] args) {
        Host host = new Host();
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}
