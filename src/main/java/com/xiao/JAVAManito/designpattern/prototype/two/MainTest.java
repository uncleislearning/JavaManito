package com.xiao.JAVAManito.designpattern.prototype.two;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class MainTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        ContreteType o1 = new ContreteType("li hua",12);
        ContreteType o2 = (ContreteType) o1.clone();
        System.out.println(o2.getName()==o1.getName());
        System.out.println(o1.getAge()==o2.getAge());
    }
}
