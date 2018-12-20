package com.xiao.JAVAManito.designpattern.decorator.temple;

/**
 * Created by unclexiao on 2017/12/23.
 */
public interface Component {
    void operation();

    default void test(){}
}
