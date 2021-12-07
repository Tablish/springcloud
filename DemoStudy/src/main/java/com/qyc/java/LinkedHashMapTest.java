package com.qyc.java;

import java.util.*;

public class LinkedHashMapTest {

    public static void main(String[] args) {

        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();//按照插入顺序
        HashMap<String, Object> hashMap = new HashMap<>();//无需
        TreeMap<Object, Object> treeMap = new TreeMap<>();//按照自然排序输出，数字 英文字母
        Hashtable<Object, Object> hashtable = new Hashtable<>();

        map.put("a", "b");
        map.put("a1", "b");
        map.put("a2", "b");
        map.put("a3", "b");

//        hashMap.put("a", "b");
//        hashMap.put("a1", "b");
//        hashMap.put("a2", "b");
//        hashMap.put("a3", "b");

        treeMap.put("b", "b");
        treeMap.put("a1", "b");
        treeMap.put("1", "b");
        treeMap.put("a", "b");

        hashtable.put("", "");


        for (Map.Entry<Object, Object> entry : hashtable.entrySet()) {
            System.out.println(entry.getKey() + " " +entry.getValue());
        }

//        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
//            System.out.println(entry.getKey() + " " +entry.getValue());
//        }
    }
}
