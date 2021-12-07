package com.qyc.designPattern.proxyDemo.demo1;

//代理角色
public class UserServiceProxy implements UserService{
    //1 需要代理谁
    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }

    void log(String method) {
        System.out.println("打印 " + method + "方法");
    }
}
