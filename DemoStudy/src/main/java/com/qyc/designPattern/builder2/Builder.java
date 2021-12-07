package com.qyc.designPattern.builder2;

//首先你要有个抽象的建造者
public abstract class Builder {
    //建造产品的生产步骤
    abstract void createA(); //地基
//    abstract void createB(); //钢筋
//    abstract void createC(); //电线
//    abstract void createD(); //粉刷

    //建造者返回一个产品
    abstract Product1 getProduct();
}
