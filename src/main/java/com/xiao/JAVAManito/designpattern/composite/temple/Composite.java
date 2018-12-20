package com.xiao.JAVAManito.designpattern.composite.temple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by unclexiao on 2017/12/23.
 */
public class Composite extends Component {
   private List<Component> childs = new ArrayList<>();

    @Override
    public void addComponent(Component component) {
        childs.add(component);
    }

    @Override
    public void removeComponent(Component component) {
        childs.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return childs.get(i);
    }

    @Override
    public void operation() {
        System.out.println("实现容器构件具体的业务方法");
        for(Component c: childs){
            c.operation();
        }
    }
}
