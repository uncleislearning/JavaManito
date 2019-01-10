/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.helper;

import com.xiao.JAVAManito.framework.annotations.Controller;
import com.xiao.JAVAManito.framework.annotations.Service;
import com.xiao.JAVAManito.framework.aop.Aspect;
import com.xiao.JAVAManito.framework.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * 类操作实现
 * <p>
 * 框架操作class的helper类：获取应用下所有的的类、带service注解的类、带controller注解的类等
 *
 * @author xiaomengning
 * @version $Id: ClassHelper.java, v 0.1 2019年01月07日 20:01 xiaomengning Exp $
 */
public final class ClassHelper {

    private static final Set<Class<?>> CLASS_SET;

    //初始化加载应用目录下所有的class文件
    static {
        String basePath = ConfigHelper.getBasePath();
        CLASS_SET = ClassUtil.loadClassSet(basePath);
    }

    /**
     * 获取应用包下所有的类
     *
     * @return
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * 获取service注解的类
     *
     * @return
     */
    public static Set<Class<?>> getServiceClassSet() {
        return getClassByTargetAnnotation(Service.class);
    }

    /**
     * 获取Controller注解的类
     *
     * @return
     */
    public static Set<Class<?>> getControllerClassSet() {
        return getClassByTargetAnnotation(Controller.class);
    }

    /**
     * bean 类 被框架管理生命周期的类：带Controller注解、Service注解等
     *
     * @return
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beanSet = new HashSet<>();
        beanSet.addAll(getServiceClassSet());
        beanSet.addAll(getControllerClassSet());
        return beanSet;
    }

    /**
     * 获取带某个注解的所有class
     */
    public static Set<Class<?>> getClassByTargetAnnotation(Class<? extends Annotation> cls) {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> item : CLASS_SET) {
            if (item.isAnnotationPresent(cls)) {
                classSet.add(item);
            }
        }

        return classSet;
    }




}