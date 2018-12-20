package com.xiao.JAVAManito.serialization;

import java.io.Serializable;

/**
 * Created by unclexiao on 2017/12/18.
 *
 * 需要进行序列化的对象
 *
 */
public class People extends Human implements Serializable{

    private static final long serialVersionUID =1L;

    private String name;
    private transient String age;
    public static int flag=2;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getFlag(){
        return flag;
    }
    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
