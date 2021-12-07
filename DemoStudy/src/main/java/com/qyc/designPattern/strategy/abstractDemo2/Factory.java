package com.qyc.designPattern.strategy.abstractDemo2;

import java.util.HashMap;

public class Factory {

    public static HashMap<String, AbstractHandler> handlerHashMap = new HashMap<>();

    public static AbstractHandler getHandler(String optType) {
        return handlerHashMap.get(optType);
    }

    public static void register(String opt, AbstractHandler obj) {
        handlerHashMap.put(opt, obj);
    }
}
