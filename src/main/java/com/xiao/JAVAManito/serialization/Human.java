package com.xiao.JAVAManito.serialization;

import java.io.Serializable;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class Human implements Serializable{
    private String sex;

    public Human() {
        sex = "男";
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
