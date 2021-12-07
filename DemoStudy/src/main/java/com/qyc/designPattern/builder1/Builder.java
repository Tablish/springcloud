package com.qyc.designPattern.builder1;

//建造者:抽象的建造者
public abstract class Builder {
    //1：建房子的每个步骤
    abstract void buildA(); //地基
    abstract void buildB(); //铺钢筋
    abstract void buildC(); //铺电线
    abstract void buildD(); //粉刷

    //2：产品：建好了房子：平房 高楼
    abstract Product getProduct();
}
