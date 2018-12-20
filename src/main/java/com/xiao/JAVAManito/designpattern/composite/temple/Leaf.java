package com.xiao.JAVAManito.designpattern.composite.temple;

/**
 * Created by unclexiao on 2017/12/23.
 */
public class Leaf extends Component{
    @Override
    public void addComponent(Component component) {
        System.out.println("叶子节点 没有子节点，抛出异常");
    }

    @Override
    public void removeComponent(Component component) {
        System.out.println("叶子节点 没有子节点，抛出异常");
    }

    @Override
    public Component getChild(int i) {
        System.out.println("叶子节点 没有子节点，抛出异常");
        return null;
    }

    @Override
    public void operation() {
        System.out.println("实现叶子节点的业务方法");
    }
}
