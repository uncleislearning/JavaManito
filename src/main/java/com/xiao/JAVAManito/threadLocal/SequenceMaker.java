/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.threadLocal;

/**
 *
 * 线程局部序列号产生器,功能希望是 每个线程调用时 都能从0，1，2，3
 * @author xiaomengning
 * @version $Id: SequenceMaker.java, v 0.1 2019年01月10日 21:20 xiaomengning Exp $
 */
public interface SequenceMaker {
    /**
     * 产生一个序列号
     * @return
     */
    int getSequenceNum();
}