package com.qyc.designPattern.bridge;

//产品
public abstract class Computer {
    //组合品牌
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public void info() {
        //自带品牌
        brand.info();
    }
}

//这是为什么，继承一个抽象类，为什么一定要生成一个构造
class DestTop extends Computer {

    public DestTop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
        System.out.print("台式机");
    }
}


class LabTop extends Computer {

    public LabTop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("笔记本");
    }
}
