package com.xiao.JAVAManito.dynamicproxy.cglib;

import com.xiao.JAVAManito.dynamicproxy.utils.DynamicProxy;

/**
 * Created by unclexiao on 2017/12/15.
 */
public class MainTest {
    public static void main(String[] args) {
         //以这种方式可以避免代理对象与目标对象耦合
        UserService su = (UserService) BeProxyBeanFactory.createProxyObject(new CGLibProxy());
        su.getWords();
        su.save("lalal");
        DynamicProxy.writeToDisk("src/main/$$EnhancerByCGLIB$$cf30f4f6.class","$$EnhancerByCGLIB$$cf30f4f6",UserServiceImpl.class);
    }

}
