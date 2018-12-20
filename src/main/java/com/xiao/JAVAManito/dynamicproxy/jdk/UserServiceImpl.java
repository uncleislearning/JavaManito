package com.xiao.JAVAManito.dynamicproxy.jdk;

/**
 * Created by unclexiao on 2017/12/15.
 */
public class UserServiceImpl implements UserService {
    @Override
    public void save(String words) {
        System.out.println("i'm saving "+words);
    }

    @Override
    public void getWords() {
        System.out.println("i'm getting words");
    }
}
