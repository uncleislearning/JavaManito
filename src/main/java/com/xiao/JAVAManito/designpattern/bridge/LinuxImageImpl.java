package com.xiao.JAVAManito.designpattern.bridge;

/**
 * Created by unclexiao on 2017/12/21.
 */
public class LinuxImageImpl implements ImageImpl {
    @Override
    public void doPaint() {
        System.out.println("Linux");
    }
}
