package com.xiao.JAVAManito.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by unclexiao on 2017/12/23.
 */
public class Folder extends AbstractFile {
    private String name;
    private List<AbstractFile> childs = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void addFile(AbstractFile abstractFile) {
        childs.add(abstractFile);
    }

    @Override
    public void removeFile(AbstractFile abstractFile) {
        childs.remove(abstractFile);
    }

    @Override
    public AbstractFile getChild(int i) {
        return childs.get(i);
    }

    @Override
    public void killVirus() {
        System.out.println("对文件夹 "+this.name+" 进行杀毒");
        for (AbstractFile af:childs){
            af.killVirus();
        }
    }
}
