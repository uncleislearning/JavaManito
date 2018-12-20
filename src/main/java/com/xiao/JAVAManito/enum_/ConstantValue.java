package com.xiao.JAVAManito.enum_;

/**
 * Created by unclexiao on 16/05/2018.
 */
public enum ConstantValue {
    SUCCESS(1,"SUCCESS"),
    ERROR(2,"ERROR"),
    WAIT(3,"WAIT"),
    STOP(4,"STOP");


    private int value;
    private String info;

    ConstantValue(int value,String info) {
        this.info = info;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static void main(String[] args) {
        System.out.println(ConstantValue.ERROR);
    }




}
