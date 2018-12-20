package com.xiao.JAVAManito.designpattern.abstractfactory;

/**
 * Created by unclexiao on 2017/12/17.
 */
public class MainTest {
    public static void main(String[] args) {
        AbstractFactory factory;
        Button button;
        TextField textField;

        //使用sprig风格
        factory = new SpringFactory();

        //使用summer风格
//        factory = new SummerFactory();

        //使用autumn风格
//        factory = new AutumnFactory();


        button = factory.createButton();
        button.display();

        textField = factory.createTextField();
        textField.display();


    }
}
