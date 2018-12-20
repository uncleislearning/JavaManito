package com.xiao.JAVAManito.designpattern.proxy.caseone;

/**
 * Created by unclexiao on 2017/12/15.
 *
 * 接口中的方法\属性 默认都是public
 * 不能是private\protected，因为private的可见性只有该类自己，protected 可见性是本类及其子类 这有违接口设计的初衷
 *
 */
public interface Searcher {
     int id=0;

     void doSearch(String id);
}
