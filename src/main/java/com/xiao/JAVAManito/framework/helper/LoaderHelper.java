/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.helper;

import com.xiao.JAVAManito.framework.util.ClassUtil;

/**
 *
 * @author xiaomengning
 * @version $Id: LoaderHelper.java, v 0.1 2019年01月07日 21:23 xiaomengning Exp $
 */
public final class LoaderHelper {

    //这里为了让加载更加集中,且有顺序，避免调用为加载的类方法
    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                //因为AOP也调用类Bean容器故要加载在Ioc之前
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class,

        };

        for(Class<?> cls : classList){
            ClassUtil.loadClass(cls.getName());
        }
    }
}