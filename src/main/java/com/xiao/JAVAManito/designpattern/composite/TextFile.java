package com.xiao.JAVAManito.designpattern.composite;


/**
 * Created by unclexiao on 2017/12/23.
 */
public class TextFile extends AbstractFile {

    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void addFile(AbstractFile abstractFile) {
        System.out.println("不支持该方法");
    }

    @Override
    public void removeFile(AbstractFile abstractFile) {
        System.out.println("不支持该方法");
    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("不支持该方法");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("对文本文件 "+ this.name+" 进行杀毒");
    }
}
