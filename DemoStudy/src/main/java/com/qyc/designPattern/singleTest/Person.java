package com.qyc.designPattern.singleTest;

public class Person {

    //2 类级别的属性，所有对象共用一个属性
    private static Person instance = null;

    //3 私有的构造方法，默认是public，所以一定要写
    private Person() {}

    //1 单例，首先构造函数一定不能提供给外部，那就用private私有的，然后通过内部的方法创建实例
    public static Person getInstance() {
        if(instance == null) {
            instance = new Person();
        }
        return instance;
    }
}
