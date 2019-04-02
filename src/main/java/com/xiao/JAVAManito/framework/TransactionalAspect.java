/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework;

import com.xiao.JAVAManito.framework.annotations.Transactional;
import com.xiao.JAVAManito.framework.aop.AspectProxy;
import com.xiao.JAVAManito.framework.aop.ProxyChain;
import com.xiao.JAVAManito.framework.helper.DatabaseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Method;

/**
 *
 * @author xiaomengning
 * @version $Id: TransactionalAspect.java, v 0.1 2019年02月02日 21:04 xiaomengning Exp $
 */
public class TransactionalAspect extends AspectProxy {

    private static Logger LOGGER = LoggerFactory.getLogger(TransactionalAspect.class);
    private static final ThreadLocal<Boolean> FLAG = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return false;
        }
    };

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {

        Object result = null;
        Method method = proxyChain.getTargetMethod();
        boolean flag = FLAG.get();
        if(!flag && method.isAnnotationPresent(Transactional.class)) {

            try {
                DatabaseHelper.beginTransactional();
                LOGGER.debug("begin transaction");
                result = proxyChain.doProxyChain();
                DatabaseHelper.commitTransaction();
                LOGGER.debug("commit transaction");
            } catch (Exception e) {
                DatabaseHelper.rollbackTransaction();
                LOGGER.debug("rollback transaction");
                throw  new RuntimeException(e);
            }finally {
                FLAG.remove();
            }

        }else {
            result = proxyChain.doProxyChain();
        }

        return result;
    }
}