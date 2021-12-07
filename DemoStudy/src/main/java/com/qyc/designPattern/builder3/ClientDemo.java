package com.qyc.designPattern.builder3;

public class ClientDemo {

    public static void main(String[] args) {

        // 1 创建一个指挥者
        Director director = new Director();
        Waiter waiter = new Waiter();
        Hamburg product = director.getProduct(waiter);
        System.out.println(product.toString());
    }
}
