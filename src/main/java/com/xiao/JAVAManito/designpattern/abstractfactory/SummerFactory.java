package com.xiao.JAVAManito.designpattern.abstractfactory;

/**
 * Created by unclexiao on 2017/12/17.
 */
public class SummerFactory implements AbstractFactory {
    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }
}
