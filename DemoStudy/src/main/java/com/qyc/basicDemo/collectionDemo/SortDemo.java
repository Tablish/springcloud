package com.qyc.basicDemo.collectionDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SortDemo {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<String> list2 = new ArrayList<String>();
        for(int i = 0; i < 10; i ++) {
            //随机获取一个值
            list1.add(new Random().nextInt(1000));
        }
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println("===================排序后：：==================");
        System.out.println(list1);

        list2.add("Alive");
        list2.add("Rose");
        list2.add("Jack");
        list2.add("Noname");
        System.out.println(list2);
        System.out.println("=====================排序后：：===================");
        Collections.sort(list2);
        System.out.println(list2);

    }
}
