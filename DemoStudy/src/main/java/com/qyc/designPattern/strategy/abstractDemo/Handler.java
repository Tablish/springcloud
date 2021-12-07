package com.qyc.designPattern.strategy.abstractDemo;

import org.springframework.beans.factory.InitializingBean;

public interface Handler extends InitializingBean {

    public void doSth();
}
