/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.annotations;

import java.lang.annotation.*;

/**
 *
 * 事务控制的注解
 * @author xiaomengning
 * @version $Id: Transactional.java, v 0.1 2019年01月27日 21:54 xiaomengning Exp $
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Transactional {
}