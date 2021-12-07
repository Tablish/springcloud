package com.qyc.basic;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(1, 1);
        Object put = hashMap.put(1, 2);
        //System.out.println(put);

        int i = 1;
        //System.out.println(i++);
        //System.out.println(i);

        int a = 1;
        System.out.println(++a);
        System.out.println(a);
    }
}
