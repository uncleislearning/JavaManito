/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.helper;

import com.xiao.JAVAManito.framework.aop.Aspect;
import com.xiao.JAVAManito.framework.aop.Proxy;
import com.xiao.JAVAManito.framework.aop.ProxyManager;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * 实现框架AOP能力
 *
 * @author xiaomengning
 * @version $Id: AopHelper.java, v 0.1 2019年01月09日 21:43 xiaomengning Exp $
 */
public final class AopHelper {

    static {
        try {
            Map<Class<?>, Set<Class<?>>> proxyMap = createProxyMap();
            Map<Class<?>, List<Proxy>> targetMap = createTargetMap(proxyMap);

            for (Map.Entry<Class<?>,List<Proxy>> targetEntry : targetMap.entrySet()) {
                 Class<?>  targetClass=  targetEntry.getKey();
                 List<Proxy> proxyList = targetEntry.getValue();

                 //1。创建代理对象
                 Object proxy =  ProxyManager.createProxy(targetClass,proxyList);

                 //2。将目标类与代理对象加入容器管理
                 BeanHelper.setBean(targetClass,proxy);
            }

        } catch (IllegalAccessException e) {

        } catch (InstantiationException e) {

        }
    }

    /**
     * 获取需要被代理的所有类
     *
     * @param aspect
     * @return
     */
    private static Set<Class<?>> createTargetClassSet(Aspect aspect) {

        Set<Class<?>> classSet = new HashSet<>();
        Class<? extends Annotation> annotationCls = aspect.value();
        if (annotationCls != null && annotationCls != Aspect.class) {
            classSet.addAll(ClassHelper.getClassByTargetAnnotation(annotationCls));
        }
        return classSet;
    }

    /**
     * 建立 切面类 与 被代理目标类的映射关系 即 ControllerAspect 与 所有  Controller 一个切面类可以代理多个目标类
     *
     * @return
     */
    private static Map<Class<?>, Set<Class<?>>> createProxyMap() {
        Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<>();

        //所有切面类
        Set<Class<?>> aspectSet = ClassHelper.getClassByTargetAnnotation(Aspect.class);

        for (Class<?> aspect : aspectSet) {

            if (aspect.isAnnotationPresent(Aspect.class)) {

                //1。拿到 ControllerAspect 类上的Aspect注解
                Aspect annoAspect = aspect.getAnnotation(Aspect.class);

                //2。拿到  Aspect注解的value，也即 ControllerAspect 需要代理的类
                proxyMap.put(aspect, createTargetClassSet(annoAspect));
            }

        }

        return proxyMap;
    }

    private static Map<Class<?>, List<Proxy>> createTargetMap(Map<Class<?>, Set<Class<?>>> proxyMap)
            throws IllegalAccessException, InstantiationException {
        Map<Class<?>, List<Proxy>> targetMap = new HashMap<>();
        for (Map.Entry<Class<?>, Set<Class<?>>> proxyEntry : proxyMap.entrySet()) {
            Class<?> proxyClass = proxyEntry.getKey();
            Set<Class<?>> targetClassSet = proxyEntry.getValue();

            //为所有的目标类，产生代理调用链
            for (Class<?> targetClass : targetClassSet) {
                Proxy proxy = (Proxy) proxyClass.newInstance();
                if (targetMap.containsKey(targetClass)) {
                    targetMap.get(targetClass).add(proxy);
                } else {
                    List<Proxy> proxyList = new ArrayList<>();
                    proxyList.add(proxy);
                    targetMap.put(targetClass, proxyList);
                }
            }
        }

        return targetMap;
    }

}