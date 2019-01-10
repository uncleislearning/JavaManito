/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xiaomengning
 * @version $Id: ReflectionUtil.java, v 0.1 2019年01月07日 20:18 xiaomengning Exp $
 */
public class ReflectionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 创建一个实例
     *
     * @param cls
     * @return
     */
    public static Object newInstance(Class<?> cls) {
        Object o = null;
        try {
            o = cls.newInstance();
        } catch (InstantiationException e) {
            LOGGER.error("new instance error" + e);
        } catch (IllegalAccessException e) {
            LOGGER.error("new instance error" + e);
            throw new RuntimeException(e);
        }
        return o;
    }

    /**
     * 设置成员变量的值
     */
    public static void setField(Object obj, Field field, Object value) {


        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            LOGGER.error("set field value failure" + e);
            throw new RuntimeException(e);
        }
    }

    public static Object invokeMethod(Object obj, Method method, Object... parmas) {

        Object o = null;
        try {
            method.setAccessible(true);
            o = method.invoke(obj, parmas);
        } catch (IllegalAccessException e) {
            LOGGER.error("invoke method failure" + e);
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            LOGGER.error("invoke method failure" + e);
            throw new RuntimeException(e);
        }

        return o;

    }
}