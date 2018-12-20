package com.xiao.JAVAManito.designpattern.proxy.caseone;

/**
 * Created by unclexiao on 2017/12/15.
 */
public class Proxy implements Searcher{

    private SearcherImpl searcher;



    public void doSearch(String id) {
        if(this.validator(id)){
            searcher.doSearch(id);
            this.log(id);
        }else {
            System.out.println("用户验证失败！");
        }
    }





    private AccessValidator av; //代理类提供的额外功能
    private Logger logger; //代理类提供的额外功能

    private UncleSorter uncleSorter = new UncleSorter();
    //代理类内部提供的额外增强功能
    private boolean validator(String id){
        this.av = new AccessValidator();
        return this.av.validate(id);
    }
    private void log(String id){
        this.logger = new Logger();
        this.logger.log(id);
    }



    public void sort() {
        uncleSorter.sort();
    }
}
