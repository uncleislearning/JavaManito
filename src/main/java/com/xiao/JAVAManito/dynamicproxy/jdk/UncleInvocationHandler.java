package com.xiao.JAVAManito.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by unclexiao on 2017/12/15.
 */
public class UncleInvocationHandler implements InvocationHandler {

    //需要代理的目标对象
    private Object target;

    //目标对象的依赖注入
    public UncleInvocationHandler(Object target){
        this.target = target;
    }
    //指定好关系（谁代理谁，代理谁的什么方法）,生成需要代理的目标对象
    public Object createProxyInstance(){
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),
                this.target.getClass().getInterfaces(),this);
    }
    //由代理对象真正地调用目标对象的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        //切面逻辑
        System.out.println("before method------");
        result = method.invoke(target,args);
        System.out.println("after method-------");
        return result;
    }
}
