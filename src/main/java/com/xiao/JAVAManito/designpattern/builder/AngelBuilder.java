package com.xiao.JAVAManito.designpattern.builder;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class AngelBuilder extends Builder {
    @Override
    void buildName() {
        actor.setName("朱利安");
    }

    @Override
    void buildCountry() {
        actor.setCountry("光辉大陆");
    }

    @Override
    void buildType() {
        actor.setType("angel");
    }
}
