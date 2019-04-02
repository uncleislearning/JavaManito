/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.threadLocal;

/**
 *
 * @author xiaomengning
 * @version $Id: SequenceMakerImpl.java, v 0.1 2019年01月10日 21:21 xiaomengning Exp $
 */
public class SequenceMakerImpl implements SequenceMaker {

    private static ThreadLocal<Integer> numContainer1 = ThreadLocal.withInitial(()->-1);

    private static MyThreadLocal<Integer> numContainer = new MyThreadLocal<Integer>(){
        @Override
        protected Integer initValue() {
            return -1;
        }
    };



    @Override
    public int getSequenceNum() {
        numContainer.set(numContainer.get()+1);
        return numContainer.get();
    }
}