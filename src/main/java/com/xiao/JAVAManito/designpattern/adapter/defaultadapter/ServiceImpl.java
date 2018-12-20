package com.xiao.JAVAManito.designpattern.adapter.defaultadapter;

/**
 * Created by unclexiao on 2017/12/21.
 */
public class ServiceImpl extends AbstractServiceImpl {
    @Override
    public void method() {
        System.out.println("只实现目前所需要的接口");
        super.method();
    }
}
