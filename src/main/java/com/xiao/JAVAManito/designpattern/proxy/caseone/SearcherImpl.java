package com.xiao.JAVAManito.designpattern.proxy.caseone;

/**
 * Created by unclexiao on 2017/12/15.
 */
public class SearcherImpl implements Searcher {
    @Override
    public void doSearch(String id) {
        System.out.println("用户 "+id+" is searching");
    }
}
