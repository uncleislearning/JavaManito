package com.xiao.JAVAManito.designpattern.abstractfactory;

/**
 * Created by unclexiao on 2017/12/17.
 */
public class AutumnFactory implements AbstractFactory {
    @Override
    public Button createButton() {
        return new AutumnButton();
    }

    @Override
    public TextField createTextField() {
        return new AutumnTextField();
    }
}
