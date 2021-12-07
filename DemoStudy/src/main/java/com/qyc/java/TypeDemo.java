package com.qyc.java;

public class TypeDemo {

    public static void main(String[] args) {
        byte b1=1,b2=2,b3,b6,b8;
        final byte b4=4,b5=6,b7;

//        b3=(b1+b2); /*语句1*/
        b6=b4+b5; /*语句2*/
 //       b8=(b1+b4); /*语句3*/
 //       b7=(b2+b5); /*语句4*/
 //       System.out.println(b3+b6);








        String str = "hello world";

        str = str + "a";

        int length = str.length();
        //str = 100;
        str = str + 100;


    }

    //应该考的是，类型的转换
    float func0() { byte i=1; return i; }
    //float func1() { int i=1; return; }                                                          //answer
    float func2() { short i=2; return i; }// float can not to short,but short can to float
    float func3() { long i=3; return i; }

    //float func4() { double i=4; return i; } //float can to double,but double can not to float   //answer






}
