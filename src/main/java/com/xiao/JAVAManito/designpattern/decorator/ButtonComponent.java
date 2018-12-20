package com.xiao.JAVAManito.designpattern.decorator;

/**
 * Created by unclexiao on 2017/12/23.
 */
public class ButtonComponent extends Component {
    @Override
    void display() {
        System.out.println("我是一个按钮");
    }
}
