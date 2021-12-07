package com.qyc.designPattern.builder2;

/**
 * 具体的建造者
 * 创建具体建造者，就相当于创建了一个产品
 */
public class Worker extends Builder {

    private Product1 product;

    public Worker() {
        product = new Product1();
    }

    @Override
    void createA() {
        product.setCreateA("地基");
        System.out.println("地基");
    }

    //上面步骤都完成后，这个产品就创建好了
    @Override
    Product1 getProduct() {
        return product;
    }
}
