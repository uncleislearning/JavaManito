package com.xiao.JAVAManito.designpattern.decorator;

/**
 * Created by unclexiao on 2017/12/23.
 */
public class MainTest  {
    public static void main(String[] args) {
        Component componentA,component,componentC;
        componentA = new WindowComponent();
        //无其他效果的窗体
        componentA.display();
        System.out.println("***********");
        //增加滚动条的窗体
        component = new ScrollBarDecorator(componentA);
        component.display();

        System.out.println("***********");
        //增加黑色边框
        componentC = new BlackBorderDecorator(component);
        componentC.display();

    }
}
