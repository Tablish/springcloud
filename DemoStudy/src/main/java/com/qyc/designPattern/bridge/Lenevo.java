package com.qyc.designPattern.bridge;

//联想电脑
public class Lenevo implements Brand{
    @Override
    public void info() {
        System.out.print("联想");
    }
}
