package com.xiao.JAVAManito.extend;

/**
 * Created by unclexiao on 20/06/2018.
 */
public class Child extends Father{
    private int age;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Child child = new Child();

        child.setA("father a");

        System.out.println(child.getA());
    }
}
