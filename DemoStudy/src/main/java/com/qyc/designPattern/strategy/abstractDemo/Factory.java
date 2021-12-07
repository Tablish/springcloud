package com.qyc.designPattern.strategy.abstractDemo;

import java.util.HashMap;

public class Factory {

    public static HashMap<String, Handler> handlerHashMap = new HashMap<>();

    public static Handler getHandler(String optType) {
        return handlerHashMap.get(optType);
    }

    public static void register(String opt, Handler obj) {
        handlerHashMap.put(opt, obj);
    }
}
