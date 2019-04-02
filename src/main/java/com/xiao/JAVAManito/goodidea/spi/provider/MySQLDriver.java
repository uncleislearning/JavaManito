/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.goodidea.spi.provider;

import com.xiao.JAVAManito.goodidea.spi.XDriver;
import com.xiao.JAVAManito.goodidea.spi.XDriverManager;

import java.sql.Connection;
import java.util.Properties;

/**
 *
 * @author xiaomengning
 * @version $Id: MySQLDriver.java, v 0.1 2019年04月02日 21:22 xiaomengning Exp $
 */
public class MySQLDriver implements XDriver {

    static {
        XDriverManager.register("driver.Mysql",MySQLDriver.class);
    }


    @Override
    public Connection connect(String url, Properties properties) {
        return null;
    }
}