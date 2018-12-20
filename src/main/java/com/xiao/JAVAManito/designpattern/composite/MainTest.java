package com.xiao.JAVAManito.designpattern.composite;

/**
 * Created by unclexiao on 2017/12/23.
 */
public class MainTest {
    public static void main(String[] args) {
        AbstractFile folder,folder1,image1,text1,image,text;
        folder = new Folder("文件夹1");
        folder1 = new Folder("子文件夹");

        image = new ImageFile("图片1");
        image1 = new ImageFile("图片2");
        text = new TextFile("文本文件1");
        text1 = new TextFile("文件文件2");
        folder.addFile(image);
        folder.addFile(text);
        folder1.addFile(image1);
        folder1.addFile(text1);
        folder.addFile(folder1);

        folder.killVirus();


    }
}
