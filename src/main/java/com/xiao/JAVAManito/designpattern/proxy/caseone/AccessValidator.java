package com.xiao.JAVAManito.designpattern.proxy.caseone;

/**
 * Created by unclexiao on 2017/12/15.
 */
public class AccessValidator {
    public boolean validate(String id){
        if(id.equals("admin")){
            System.out.println("登陆成功");
            return true;
        }else {
            System.out.println("登陆失败");
            return false;
        }
    }
}
