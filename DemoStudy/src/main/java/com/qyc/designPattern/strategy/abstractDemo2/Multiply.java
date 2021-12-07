package com.qyc.designPattern.strategy.abstractDemo2;

import org.springframework.stereotype.Component;

@Component
public class Multiply extends AbstractHandler {
    @Override
    public void AAA() {
        System.out.println("add");
    }

    @Override
    public void BBB() {
        System.out.println("multiply");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Factory.register("Multiply", this);
    }
}
