/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.threadLocal;

/**
 *
 * 学习使用ThreadLocal的API
 * @author xiaomengning
 * @version $Id: TestThreadLocal.java, v 0.1 2019年01月10日 21:18 xiaomengning Exp $
 */
public class TestThreadLocal {

    public static void main(String[] args) {

        /**
         * 多个线程共享同一个序列号产生器
         */
        SequenceMaker sequenceMaker = new SequenceMakerImpl();

        /**
         * 模拟多个线程同时使用 sequenceMaker 去产生序列号
         */
        new ClientThread(sequenceMaker).start();
        new ClientThread(sequenceMaker).start();
        new ClientThread(sequenceMaker).start();
    }


    static class ClientThread extends Thread{

        private SequenceMaker sequenceMaker;

        public ClientThread(SequenceMaker sequenceMaker){
            this.sequenceMaker = sequenceMaker;
        }


        @Override
        public void run() {

            /**
             * 模拟每个线程的工作 使用sequenceMaker 产生三次序号
             */
            for(int i=0;i<3;i++){
                System.out.println(Thread.currentThread().getName()+"=>"+sequenceMaker.getSequenceNum());
            }
        }
    }
}