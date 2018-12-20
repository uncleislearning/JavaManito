package com.xiao.JAVAManito.dynamicproxy.cglib.review;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;


/**
 * Created by unclexiao on 2017/12/15.
 */
public class BeProxyBeanFactory {
    public static Object createProxyObject(MethodInterceptor methodInterceptor){
        Enhancer enhancer = new Enhancer();
        //设置代理类的父类
        enhancer.setSuperclass(UserService.class);
        //设置拦截器，CGlib框架会拦截调用，并调用拦截器中的invoke
        enhancer.setCallback(methodInterceptor);

        return enhancer.create();
    }
}
