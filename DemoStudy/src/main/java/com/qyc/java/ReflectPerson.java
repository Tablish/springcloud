package com.qyc.java;

public class ReflectPerson {

    public String name;

    public String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ReflectPerson() {
    }

    public ReflectPerson(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ReflectPerson{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
