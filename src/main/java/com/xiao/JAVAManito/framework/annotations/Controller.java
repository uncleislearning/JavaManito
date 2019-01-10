/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.annotations;

import java.lang.annotation.*;

/**
 *
 * @author xiaomengning
 * @version $Id: Controller.java, v 0.1 2018年12月25日 21:31 xiaomengning Exp $
 *
 *
 * 被该注解修饰的类表示：
 * 1。生命周期被容器管理
 * 2。是控制层对象
 */

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
}