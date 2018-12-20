package com.xiao.JAVAManito.designpattern.bridge;

/**
 * Created by unclexiao on 2017/12/21.
 */
public class MainTest {
    public static void main(String[] args) {
        Image image;
        ImageImpl imageimpl;
        image = new GIFImage();
        imageimpl = new WindosImageImpl();
        image.setImageImpl(imageimpl);

        image.parseFile("file");
    }
}
