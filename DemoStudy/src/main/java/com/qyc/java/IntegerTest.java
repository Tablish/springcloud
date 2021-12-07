package com.qyc.java;

public final class IntegerTest {

    public static void main(String[] args) {

        Integer integer = Integer.valueOf(2); //自动装箱 -127 - 128 取的是缓存

        int i = integer.intValue();           //拆箱


    }



}
