package com.qyc.designPattern.strategy.abstractDemo2;

import org.springframework.stereotype.Component;

@Component
public class Add extends AbstractHandler {
    @Override
    public void AAA() {
        System.out.println("AAA");
    }

    @Override
    public void BBB() {
        System.out.println("BBB");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Factory.register("Add", this);
    }
}
