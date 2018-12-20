package com.xiao.JAVAManito.designpattern.bridge;

/**
 * Created by unclexiao on 2017/12/21.
 */
public abstract class Image {

    protected ImageImpl imageImpl;

    abstract void parseFile(String name);

    public void setImageImpl(ImageImpl imageImpl) {
        this.imageImpl = imageImpl;
    }
}
