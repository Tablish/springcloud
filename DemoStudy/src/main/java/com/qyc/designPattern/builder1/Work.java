package com.qyc.designPattern.builder1;

//具体的建造者：工人
public class Work extends Builder{

    private Product product;

    //工人创建产品，不是传过来的
    public Work() {
        product = new Product();
    }

    @Override
    void buildA() {
        product.setBuildA("地基");
        System.out.println("地基");
    }

    @Override
    void buildB() {
        product.setBuildA("钢筋");
        System.out.println("钢筋");
    }

    @Override
    void buildC() {
        product.setBuildA("电线");
        System.out.println("电线");
    }

    @Override
    void buildD() {
        product.setBuildA("粉刷");
        System.out.println("粉刷");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
