package com.qyc.designPattern.strategy.simple;

public class Client {
    public static void main(String[] args) {

        String operation = "add";

        Context addContext = new Context(new AddOperation());
        int addResult = addContext.doSom(1, 1);
        System.out.println(addResult);

        Context multiplyContext = new Context(new MultiplyOperation());
        int multiplyResult = multiplyContext.doSom(1, 1);
        System.out.println(multiplyResult);

        //普通的if...else...
//        if("add".equals(operation)) {
//            AddOperation addOperation = new AddOperation();
//            int i1 = addContext.doSom(1, 1);
//        } else if("multiply".equals(operation)) {
//            //乘操作
//        }
    }
}
