package com.qyc.designPattern.strategy.abstractDemo;

import org.springframework.stereotype.Component;

@Component
public class Add implements Handler{
    @Override
    public void doSth() {
        System.out.println("add");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Factory.register("add", this);
    }
}
