package com.qyc.designPattern.builder2;

public class ClientDemo {

    public static void main(String[] args) {

        Director director = new Director();
        Worker work = new Worker();
        Product1 product1 = director.getProduct1(work);
        System.out.println(product1.toString());
    }
}
