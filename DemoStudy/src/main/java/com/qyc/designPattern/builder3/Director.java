package com.qyc.designPattern.builder3;

//指挥者
public class Director {

    public Hamburg getProduct(Builder builder) {
        builder.createTaoCan();
        builder.createIceCream();
        Hamburg product = builder.getProduct();
        return product;
    }
}
