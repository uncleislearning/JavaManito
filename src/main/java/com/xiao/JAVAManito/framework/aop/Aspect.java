/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.aop;

import java.lang.annotation.*;

/**
 *
 * @author xiaomengning
 * @version $Id: Aspect.java, v 0.1 2019年01月09日 21:23 xiaomengning Exp $
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Aspect {

    /**
     * value 是一个注解类
     * @return
     */
    Class<? extends Annotation> value();
}