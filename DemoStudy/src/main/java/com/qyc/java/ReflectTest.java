package com.qyc.java;

public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {


        ReflectPerson person = new ReflectPerson("1", "1");
        System.out.println("method one " + person.getClass());

        System.out.println("method two " + ReflectPerson.class);
        System.out.println("method two " + ReflectPerson.class.getMethods());



        Class<?> aClass = Class.forName("com.qyc.java.ReflectPerson");

        ReflectPerson o = (ReflectPerson) aClass.newInstance();

        o.setAge("age");
        o.setName("name");

        System.out.println(aClass.getMethods());
        System.out.println(o);



    }
}
