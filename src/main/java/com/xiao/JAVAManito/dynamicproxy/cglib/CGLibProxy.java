package com.xiao.JAVAManito.dynamicproxy.cglib;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by unclexiao on 2017/12/15.
 *
 */
public class CGLibProxy implements MethodInterceptor {

    /**
     *
     * @param o  被产生的代理类对象
     * @param method    目标代理的方法
     * @param objects   方法的参数
     * @param methodProxy   为生成的代理类对方法的代理引用
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object res;
        System.out.println("----before");
        System.out.println("proxy:"+o.getClass().getName());
        res = methodProxy.invokeSuper(o,objects);
        System.out.println("----after");
        return res;
    }
}
