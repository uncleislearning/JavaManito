package com.xiao.JAVAManito.dynamicproxy.cglib.review;


import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by unclexiao on 11/04/2018.
 */
public class Main {
    public static void main(String[] args) {

        //将代理类的字节码保存到磁盘
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "src/main");

        Enhancer enhancer = new Enhancer();
        //设置代理类的父类
        enhancer.setSuperclass(UserService.class);
        //设置拦截器，CGlib框架会拦截调用，并调用拦截器中的invoke
        enhancer.setCallback(new UserServiceMethodInterceptor());

        UserService us = (UserService) enhancer.create();
        us.getWords();
        us.save("book");
    }
}
