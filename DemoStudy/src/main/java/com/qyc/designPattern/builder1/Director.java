package com.qyc.designPattern.builder1;

//指挥：核心：负责指挥构建一个工程，工程如何构建，由他决定
public class Director {

    //指挥工人按照顺序构建房子
    public Product createProduct (Builder builder) {
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();
        return builder.getProduct();
    }
}
