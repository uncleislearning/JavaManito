package com.xiao.JAVAManito.designpattern.proxy.caseone;

/**
 * Created by unclexiao on 2017/12/15.
 */
public class MainTest {
    public static void main(String[] args) {

        Searcher sc = new Proxy();

        //客户端使用代理类来调用目标类的功能
        sc.doSearch("admin");

       // Sorter sorter = new Proxy();
        //同一个代理类，通过实现多个不同的接口，可以代理多个不同的类
       // sorter.sort();

    }
}
