package com.qyc.designPattern.singleTest;

public class Client {
    public static void main(String[] args) {
        //Person person1 = new Person();
        //Person person2 = new Person();

        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
    }
}
