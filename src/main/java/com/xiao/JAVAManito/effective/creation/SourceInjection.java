package com.xiao.JAVAManito.effective.creation;

/**
 * Created by unclexiao on 16/05/2018.
 *
 *
 * 这是一个很好的模式，而且SourceInjection 一旦实例化就是不可变的（没有设置修改操作、内部依赖的资源使用final）
 *
 */
public class SourceInjection {
    //依赖的资源
    private final Source source;


    //通过构造函数进行依赖的注入，不要将资源的生成工作 写死在代码中
    public SourceInjection(Source source) {
        this.source = source;
    }

    //使用资源做一些事情
    public void doSomethingDependonSource(){
        System.out.println(source.hashCode());
    }


    public static void main(String[] args) {
        SourceInjection singletonBean = new SourceInjection(new Source());

        singletonBean.doSomethingDependonSource();
    }


    static class Source{

    }

}
