package com.qyc.designPattern.strategy.abstractDemo;

import org.springframework.stereotype.Component;

@Component
public class Multiply implements Handler{
    @Override
    public void doSth() {
        System.out.println("multiply");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Factory.register("multiply", this);
    }
}
