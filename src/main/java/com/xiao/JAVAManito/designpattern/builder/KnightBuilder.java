package com.xiao.JAVAManito.designpattern.builder;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class KnightBuilder extends Builder {
    @Override
    void buildName() {
        actor.setName("古卡斯");
    }

    @Override
    void buildCountry() {
        actor.setCountry("文明之都");
    }

    @Override
    void buildType() {
        actor.setType("knight");
    }
}
