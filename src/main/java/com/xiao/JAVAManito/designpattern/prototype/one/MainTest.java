package com.xiao.JAVAManito.designpattern.prototype.one;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class MainTest {
    public static void main(String[] args) {

        Contrete prototype1 = new Contrete("aaa");

        Contrete prototype2 = (Contrete) prototype1.cloneObject();

        //false
        System.out.println(prototype1 == prototype2);

        //true
        System.out.println(prototype2.getName()==prototype1.getName());

        System.out.println(prototype2.getName()+","+prototype1.getName());

    }
}
