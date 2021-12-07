package com.qyc.designPattern.proxyDemo.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyClass implements InvocationHandler {

    //需要被代理的对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //获得代理类，中介
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    //反射 进行业务的增强
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("约会前的准备，准备tt");
        Object invoke = method.invoke(target, args);
        System.out.println("约会中，滚床单");
        System.out.println("约会后，喝一杯枸杞水");
        return invoke;
    }
}
