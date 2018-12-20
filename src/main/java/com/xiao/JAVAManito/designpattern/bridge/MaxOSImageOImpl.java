package com.xiao.JAVAManito.designpattern.bridge;

/**
 * Created by unclexiao on 2017/12/21.
 */
public class MaxOSImageOImpl implements ImageImpl {
    @Override
    public void doPaint() {
        System.out.println("MacOS");
    }
}
