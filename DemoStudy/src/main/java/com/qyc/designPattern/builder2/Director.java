package com.qyc.designPattern.builder2;


//指挥者：指挥建造者造房子
public class Director {
    public Director() {
    }

    public Product1 getProduct1(Builder builder) {
        builder.createA();
        Product1 product = builder.getProduct();
        return product;
    }
}
