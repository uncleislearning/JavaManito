package com.xiao.JAVAManito.designpattern.composite.temple;



/**
 * Created by unclexiao on 2017/12/23.
 */
public abstract class Component {
    //添加成员
    public abstract void addComponent(Component component);

    //删除成员
    public abstract void removeComponent(Component component);

    //获取成员
    public abstract Component getChild(int i);

    //业务方法
    public abstract void operation();
}
