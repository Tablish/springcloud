package com.qyc.designPattern.builder3;


//抽象的建造者
public abstract class Builder {

    abstract void createTaoCan(); //汉堡套餐
    abstract void createIceCream(); //冰淇淋
    abstract Hamburg getProduct();
}
