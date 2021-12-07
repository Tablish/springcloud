package com.qyc.basicDemo.collectionDemo;

import java.util.ArrayList;
import java.util.Collections;

public class ClientDemo {

    public static void main(String[] args) {
        ArrayList<Cell> cells = new ArrayList<>();
//        cells.add(new Cell(2, 3));
//        cells.add(new Cell(5, 3));
//        cells.add(new Cell(9, 1));
//        cells.add(new Cell(7, 30));
//
//        System.out.println(cells);
//        System.out.println("=================排序后的集合：：====================");
//        Collections.sort(cells);
//        System.out.println(cells);

        System.out.println("=================================");
        ArrayList<Cell> cells2 = new ArrayList<>();
        cells2.add(new Cell(2, 3));
        cells2.add(new Cell(5, 2));
        cells2.add(new Cell(7, 67));
        cells2.add(new Cell(1, 39));

        System.out.println(cells2);
        System.out.println("=================排序后的集合：：====================");
        MyComparator myComparator = new MyComparator();
        Collections.sort(cells2, myComparator);
        System.out.println(cells2);
    }
}
