package com.xiao.JAVAManito.designpattern.decorator.temple;

/**
 * Created by unclexiao on 2017/12/23.
 */
public class MainTest {
    public static void main(String[] args) {
        Component component,component1;
        component = new ConcreteComponent();
        //在具体组件的功能之上，增加新的功能
         component1 = new ContreteDecorator(component);

        //包含之前组件原有功能
        component1.operation();
    }
}
