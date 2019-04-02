/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.goodidea.spi;

import java.sql.Connection;
import java.util.Properties;

/**
 *
 *
 * spi 定义
 * @author xiaomengning
 * @version $Id: XDriver.java, v 0.1 2019年04月02日 21:21 xiaomengning Exp $
 */
public interface XDriver {
    public Connection connect(String url, Properties properties);
}