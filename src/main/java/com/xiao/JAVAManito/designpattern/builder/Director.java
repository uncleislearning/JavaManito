package com.xiao.JAVAManito.designpattern.builder;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class Director {
    private Builder builder;

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }
    public Actor construct(){
        builder.buildCountry();
        builder.buildName();
        builder.buildType();
        return builder.getActor();
    }

}
