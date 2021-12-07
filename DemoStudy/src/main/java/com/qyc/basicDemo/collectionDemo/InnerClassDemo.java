package com.qyc.basicDemo.collectionDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InnerClassDemo {

    public static void main(String[] args) {
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(new Cell(2,3));
        cells.add(new Cell(5,1));
        cells.add(new Cell(3,2));
        System.out.println(cells);
        Collections.sort(cells, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.getY() - o2.getY();
            }
        });

        System.out.println("=============================排序后的集合==============================");
        System.out.println(cells);
    }
}
