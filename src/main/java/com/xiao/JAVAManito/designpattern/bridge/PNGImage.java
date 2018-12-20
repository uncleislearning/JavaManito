package com.xiao.JAVAManito.designpattern.bridge;

/**
 * Created by unclexiao on 2017/12/21.
 */
public class PNGImage extends Image {
    @Override
    void parseFile(String name) {
        imageImpl.doPaint();
        System.out.println("PNG");
    }
}
