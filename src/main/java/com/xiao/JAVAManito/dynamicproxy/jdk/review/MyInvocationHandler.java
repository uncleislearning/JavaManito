package com.xiao.JAVAManito.dynamicproxy.jdk.review;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by unclexiao on 10/04/2018.
 *
 * 代理类将持有一个InvocationHandler实例引用，并调用invoke方法
 */
public class MyInvocationHandler implements InvocationHandler {

    //持有被代理目标类的引用
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("proxy :"+proxy.getClass().getName());
        System.out.println("Method："+method.getName());
//          调用被代理类的目标方法
          return  method.invoke(target,args);
    }
}
