package com.xiao.JAVAManito.designpattern.decorator;

/**
 * Created by unclexiao on 2017/12/23.
 */
public class Decorator extends Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    void display() {
        this.component.display();
    }
}
