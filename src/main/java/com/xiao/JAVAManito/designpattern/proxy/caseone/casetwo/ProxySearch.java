package com.xiao.JAVAManito.designpattern.proxy.caseone.casetwo;

import com.xiao.JAVAManito.designpattern.proxy.caseone.AccessValidator;
import com.xiao.JAVAManito.designpattern.proxy.caseone.Logger;

/**
 * Created by unclexiao on 10/04/2018.
 *
 * 使用继承的方式同样实现了该功能
 *
 * 相比于实现接口的方式，使用继承的方式，一个代理类只能代理一个类，原因是Java只支持单继承
 */
public class ProxySearch extends Searcher {

   @Override
    public void search(String id) {

        if(validator(id)){
            super.search(id);
        }else {
            log(id);
        }
    }



    private AccessValidator av; //代理类提供的额外功能
    private Logger logger; //代理类提供的额外功能

    //代理类内部提供的额外增强功能
    private boolean validator(String id){
        this.av = new AccessValidator();
        return this.av.validate(id);
    }
    private void log(String id){
        this.logger = new Logger();
        this.logger.log(id);
    }

}
