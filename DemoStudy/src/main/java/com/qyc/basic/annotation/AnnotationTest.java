package com.qyc.basic.annotation;

import com.qyc.java.Person;

public class AnnotationTest {

    public static void main(String[] args) {

        Class<Person> aClass = Person.class;

        if(aClass.isAnnotationPresent(Info.class)) {
            System.out.println("Person类上配置了Info注解！");
            Info annotation = aClass.getAnnotation(Info.class);
            System.out.println("person.name :" + annotation.value() + ",person.isDelete:" + annotation.isDelete());
        } else {
            System.out.println("Person类上没有配置Info注解！");
        }
    }
}
