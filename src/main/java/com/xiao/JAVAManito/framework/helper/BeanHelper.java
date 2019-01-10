/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.helper;

import com.xiao.JAVAManito.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * Bean 容器的实现
 * @author xiaomengning
 * @version $Id: BeanHelper.java, v 0.1 2019年01月07日 20:23 xiaomengning Exp $
 */
public class BeanHelper {
    private static final Map<Class<?>,Object> BEAN_MAP = new HashMap<>();

    /**
     * 类加载时初始化容器
     */
    static {
        Set<Class<?>> beanClassSet =  ClassHelper.getBeanClassSet();
        for(Class<?> cls:beanClassSet){
            BEAN_MAP.put(cls, ReflectionUtil.newInstance(cls));
        }
    }

    /**
     * 获取容器 bean映射
     * @return
     */
    public static Map<Class<?>,Object>  getBeanMap(){
        return BEAN_MAP;
    }

    /**
     *
     *  获取一个bean实例
     * @param cls
     * @return
     */
    public static <T> T getBeanInstance(Class<T> cls){

        //这里异常处理的机制：抛出一个异常，以告诉使用者出现问题，如果不做判断，那意味着 方法使用者需要注意异常，也就是处理返回为null的情况，但这种方式不好，造成冗余代码
        if(!BEAN_MAP.containsKey(cls)){
           throw new RuntimeException("cant not get bean by class:"+cls);
        }

        return (T)BEAN_MAP.get(cls);
    }



    public static void setBean(Class<?> cls,Object beanInstance){
        BEAN_MAP.put(cls,beanInstance);
    }
}