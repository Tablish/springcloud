package com.qyc.designPattern.builder3;


//具体建造者
public class Waiter extends Builder{

    //服务员是要出产品的
    private Hamburg product;

    public Waiter() {
        product = new Hamburg();
    }

    @Override
    void createTaoCan() {
        product.setTaoCan("套餐");
        System.out.println("套餐");
    }

    @Override
    void createIceCream() {
        product.setIceCream("冰淇淋");
        System.out.println("冰淇淋");
    }

    @Override
    Hamburg getProduct() {
        return product;
    }
}
