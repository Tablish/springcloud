package com.qyc.designPattern.proxyDemo.demo1;

//业务场景：需要给userService每个方法增加一行日志！
public class UserServiceTest {

    public static void main(String[] args) {
        //before
        UserServiceImpl userService1 = new UserServiceImpl();
        userService1.add();
        System.out.println("------------------------------");
        //after
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);
        proxy.add();
    }
}
