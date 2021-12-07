package com.qyc.basicDemo.collectionDemo;

public class Cell implements Comparable<Cell>{
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Cell o) {//自定义排序逻辑
        return o.x - this.x;//以传入的Cell的横坐标由小到大进行排序
    }
}
