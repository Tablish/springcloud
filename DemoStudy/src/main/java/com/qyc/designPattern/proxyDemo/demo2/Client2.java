package com.qyc.designPattern.proxyDemo.demo2;

import com.qyc.designPattern.proxyDemo.demo1.UserService;
import com.qyc.designPattern.proxyDemo.demo1.UserServiceImpl;

public class Client2 {
    public static void main(String[] args) {

        //需要代理的对象
        UserServiceImpl userService = new UserServiceImpl();

        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(userService);
        //获取动态代理类
        UserService proxy = (UserService) pih.getProxy();
        proxy.add();
    }
}
