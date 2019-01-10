/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 *
 * 代理对象创建管理器:
 *
 *
 * 代理对象 将对 被代理对象 依次执行代理方法
 * @author xiaomengning
 * @version $Id: ProxyManager.java, v 0.1 2019年01月09日 20:23 xiaomengning Exp $
 */
public class ProxyManager {

    public static <T> T createProxy(final Class<?> targetClass,final List<Proxy> proxyList){
        return(T)Enhancer.create(targetClass, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return new ProxyChain(targetClass,o,method,methodProxy,objects,proxyList).doProxyChain();
            }
        });
    }
}