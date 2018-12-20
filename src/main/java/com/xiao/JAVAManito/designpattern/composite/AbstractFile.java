package com.xiao.JAVAManito.designpattern.composite;

import java.util.List;

/**
 * Created by unclexiao on 2017/12/23.
 */
public abstract class AbstractFile {
    public  void addFile(AbstractFile abstractFile){

    }

    public abstract void removeFile(AbstractFile abstractFile);

    public abstract AbstractFile getChild(int i);

    public abstract void killVirus();

}
