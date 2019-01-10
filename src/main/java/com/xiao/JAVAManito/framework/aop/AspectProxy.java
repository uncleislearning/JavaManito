/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.aop;

import java.lang.reflect.Method;

/**
 *
 * 抽象切面类 也是 AOP 增强的实现框架
 * @author xiaomengning
 * @version $Id: AspectProxy.java, v 0.1 2019年01月09日 20:53 xiaomengning Exp $
 */
public abstract class AspectProxy implements Proxy {



    //钩子方法，用于通过各种方法的增强


    protected  void before(Class<?> cls, Method method, Object[] params){

    }

    protected  void after(Class<?> cls, Method method, Object[] params){

    }

    protected  void afterThrowable(Class<?> cls, Method method, Object[] params, Throwable e){

    }


    protected  void begin(){

    }

    protected  void end(){

    }


    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;

        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();

        begin();
        try {
            if(intercept(cls,method,params)){
                before(cls,method,params);
                result = proxyChain.doProxyChain();
                after(cls,method,params);
            }else {
                //可以选择跳过代理
                result = proxyChain.doProxyChain();
            }

        }catch (Throwable e){
            afterThrowable(cls,method,params,e);
            throw e;
        }finally {
            end();
        }


        return result;
    }


    //默认走前后代理的方式
    protected boolean intercept(Class<?> cls,Method method,Object[] params){
        return true;
    }
}