package com.xiao.JAVAManito.designpattern.simplefactory;

/**
 * Created by unclexiao on 2017/12/16.
 */
public class CircleShape implements Shape {
//    private String name;
//
//    public CircleShape(String name) {
//        this.name = name;
//    }

    @Override
    public void draw() {
        System.out.println("正在绘制圆形");
    }

    @Override
    public void erase() {
        System.out.println("正在擦出圆形");
    }
}
