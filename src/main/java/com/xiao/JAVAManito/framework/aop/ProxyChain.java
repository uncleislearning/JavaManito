/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.aop;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 代理方法链
 *
 * @author xiaomengning
 * @version $Id: ProxyChain.java, v 0.1 2019年01月09日 20:02 xiaomengning Exp $
 */
public class ProxyChain {

    private final Class<?>    targetClass;
    private final Object      targetObject;
    private final Method      targetMethod;
    private final MethodProxy methodProxy;
    private final Object[]    methodParams;

    public ProxyChain(Class<?> targetClass, Object targetObject, Method targetMethod, MethodProxy methodProxy, Object[] methodParams,List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.targetMethod = targetMethod;
        this.methodProxy = methodProxy;
        this.methodParams = methodParams;
        this.proxyList = proxyList;
    }

    /**
     * 实现链式代理
     */
    private List<Proxy> proxyList  = new ArrayList<>();
    private int         proxyIndex = 0;


    public Object doProxyChain() throws Throwable {
        Object methdoResult;
        if (proxyIndex < proxyList.size()) {
            methdoResult = proxyList.get(proxyIndex++).doProxy(this);
        } else {
            //链尾
            methdoResult = methodProxy.invoke(targetObject, methodParams);
        }
        return methdoResult;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public MethodProxy getMethodProxy() {
        return methodProxy;
    }

    public Object[] getMethodParams() {
        return methodParams;
    }
}