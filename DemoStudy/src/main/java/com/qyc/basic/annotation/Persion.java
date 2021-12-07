package com.qyc.basic.annotation;

@Info(isDelete = false)
public class Persion {

    private String name;

    private int age;

    private boolean isDelete;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Persion(String name, int age, boolean isDelete) {
        this.name = name;
        this.age = age;
        this.isDelete = isDelete;
    }
}
