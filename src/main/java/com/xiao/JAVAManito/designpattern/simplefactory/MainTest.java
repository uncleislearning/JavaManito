package com.xiao.JAVAManito.designpattern.simplefactory;

import sun.security.provider.SHA;

/**
 * Created by unclexiao on 2017/12/16.
 */
public class MainTest {
    public static void main(String[] args) {
        Shape shape = ShapeFactory.getShape("circle");
        shape.draw();

        Shape shape1 = ShapeFactory.getShape("square");
        shape1.draw();
    }
}
