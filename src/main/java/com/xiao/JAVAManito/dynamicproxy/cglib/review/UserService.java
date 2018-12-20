package com.xiao.JAVAManito.dynamicproxy.cglib.review;

/**
 * Created by unclexiao on 11/04/2018.
 *
 * 目标类
 */
public class UserService {

    public void save(String words) {
        System.out.println("i'm saving "+words);
    }

    public void getWords() {
        System.out.println("i'm getting words");
    }
}
