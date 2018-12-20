package com.xiao.JAVAManito.designpattern.builder;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class DemonBuilder extends Builder {
    @Override
    void buildName() {
        actor.setCountry("萨福德");
    }

    @Override
    void buildCountry() {
        actor.setName("暗黑大陆");
    }

    @Override
    void buildType() {
        actor.setType("demon");
    }
}
