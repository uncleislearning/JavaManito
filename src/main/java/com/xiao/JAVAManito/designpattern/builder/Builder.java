package com.xiao.JAVAManito.designpattern.builder;

/**
 * Created by unclexiao on 2017/12/18.
 */
public abstract class Builder {
    protected Actor actor = new Actor();
    abstract void buildName();
    abstract void buildCountry();
    abstract void buildType();

    public Actor getActor(){
        return actor;
    }
}
