/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework;

import com.xiao.JAVAManito.framework.annotations.Controller;
import com.xiao.JAVAManito.framework.aop.Aspect;
import com.xiao.JAVAManito.framework.aop.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 *
 * 一个切面实例：对controller每个接口的执行时间 进行记录
 * @author xiaomengning
 * @version $Id: ControllerAspect.java, v 0.1 2019年01月09日 21:22 xiaomengning Exp $
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);


    private long begin;

    /**
     * 前置增强
     * @param cls
     * @param method
     * @param params
     */
    @Override
    protected void before(Class<?> cls, Method method, Object[] params) {
        LOGGER.debug("--------begin-----");
        LOGGER.debug(String.format("class:%s",cls.getName()));
        LOGGER.debug(String.format("method:%s",method.getName()));
        begin = System.currentTimeMillis();
    }

    /**
     * 后置增强
     * @param cls
     * @param method
     * @param params
     */

    @Override
    protected void after(Class<?> cls, Method method, Object[] params) {

        LOGGER.debug(String.format("cost time:%dms",System.currentTimeMillis()-begin));
        LOGGER.debug("------end-------");
    }
}