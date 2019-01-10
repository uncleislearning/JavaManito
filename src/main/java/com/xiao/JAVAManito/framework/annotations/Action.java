/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.annotations;

import java.lang.annotation.*;

/**
 *
 * @author xiaomengning
 * @version $Id: Action.java, v 0.1 2018年12月25日 21:48 xiaomengning Exp $
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String value();
}