/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.threadLocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 *
 * 实现一个ThreadLocal，理解ThreadLocal的原理
 *
 * ThreadLocal 保存的变量，可以使得每个线程自己操作自己的变量
 * @author xiaomengning
 * @version $Id: MyThreadLocal.java, v 0.1 2019年01月10日 21:50 xiaomengning Exp $
 */
public class MyThreadLocal<T> {


    //在Threadlocal里面 每个Thread 中有一个map，threadlocal --》线程保存的值


    //这里实现思路不一样，这里是多个线程 公用一个map；Threadlocal本身没有map，而是每个线程都有自己的map
    private  Map<Thread,T> containerMap = new ConcurrentHashMap<>();


    protected T initValue(){
        return null;
    }


    public T get(){
        Thread curThread = Thread.currentThread();

        T value = containerMap.get(curThread);

        if(value==null && !containerMap.containsKey(curThread)){
            value = initValue();
        }

        return value;
    }

    public void set(T value){
        //直接覆盖
        containerMap.put(Thread.currentThread(),value);
    }

    public void remove(){
        containerMap.remove(Thread.currentThread());
    }
}