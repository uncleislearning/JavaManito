package com.xiao.JAVAManito.designpattern.prototype.one;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class Contrete extends Prototype {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contrete(String name) {
        this.name = name;
    }

    @Override
    Prototype cloneObject() {
        //在这里创建一个与this对象内容相同的对象
        Prototype prototype = new Contrete(this.name);
        return prototype;
    }
}
