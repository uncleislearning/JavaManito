package com.xiao.JAVAManito.dynamicproxy.cglib.review;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by unclexiao on 11/04/2018.
 */
public class UserServiceMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object proxy, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        Object res;
        System.out.println("proxy:"+proxy.getClass().getName());
        //
        System.out.println("----before");
        res = methodProxy.invokeSuper(proxy,params);
        System.out.println("----after");

        return res;
    }
}
