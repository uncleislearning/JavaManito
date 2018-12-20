package com.xiao.JAVAManito.designpattern.proxy.caseone.casetwo;


/**
 * Created by unclexiao on 2017/12/15.
 */
public class MainTest {
    public static void main(String[] args) {
        Searcher searcher = new ProxySearch();
        searcher.search("admin");
    }
}
