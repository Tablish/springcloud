package com.qyc.designPattern.builder1;

public class ClientDemo {

    public static void main(String[] args) {
        //指挥
        Director director = new Director();
        //指挥 具体的工人完成 产品
        Product product = director.createProduct(new Work());
        System.out.println(product.toString());
    }
}
