package com.qyc.designPattern.builder3;

//产品
public class Hamburg {

    private String taoCan;

    private String iceCream;

    public String getTaoCan() {
        return taoCan;
    }

    public void setTaoCan(String taoCan) {
        this.taoCan = taoCan;
    }

    public String getIceCream() {
        return iceCream;
    }

    public void setIceCream(String iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String toString() {
        return "Hamburg{" +
                "taoCan='" + taoCan + '\'' +
                ", iceCream='" + iceCream + '\'' +
                '}';
    }
}
