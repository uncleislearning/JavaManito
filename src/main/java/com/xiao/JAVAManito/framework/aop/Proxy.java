/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.aop;

/**
 *
 * 代理方法接口
 * @author xiaomengning
 * @version $Id: Proxy.java, v 0.1 2019年01月09日 20:00 xiaomengning Exp $
 */
public interface Proxy {

    /**
     *
     * 执行链式代理
     * @param proxyChain  代理链
     * @return
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}