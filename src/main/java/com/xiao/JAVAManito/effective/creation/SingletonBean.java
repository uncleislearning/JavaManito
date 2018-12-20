package com.xiao.JAVAManito.effective.creation;

import java.io.Serializable;

/**
 * Created by unclexiao on 16/05/2018.
 *
 * 如何实现Singleton 类的序列化(即保证 类只被实例化一次):
 *
 * 1.将所有的filed 设为 transient
 * 2.添加readResolve()方法
 *
 *
 */
public class SingletonBean implements Serializable{

    public transient static final SingletonBean INSTANCE = new SingletonBean();

    private SingletonBean(){

    }

    private Object readResolve(){
        return INSTANCE;
    }

}
