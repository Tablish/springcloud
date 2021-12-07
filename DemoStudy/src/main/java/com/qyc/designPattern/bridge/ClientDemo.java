package com.qyc.designPattern.bridge;

public class ClientDemo {

    public static void main(String[] args) {

        //苹果笔记本
        Computer computer = new LabTop(new Apple());
        //联想台式机
        DestTop destTop = new DestTop(new Lenevo());
        computer.info();
        destTop.info();
    }
}
