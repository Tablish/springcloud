package com.qyc.basicDemo.collectionDemo;

import java.util.Comparator;

public class MyComparator implements Comparator<Cell> {

    @Override
    public int compare(Cell o1, Cell o2) {
        return o2.getY() - o1.getY();
    }
}
