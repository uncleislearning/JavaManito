package com.xiao.JAVAManito.spring.aop.exam1;

import org.springframework.stereotype.Component;

/**
 * Created by unclexiao on 17/04/2018.
 *
 * 权限管理服务
 */
@Component
public class AuthService {

    public boolean isAdmin(String identity){
        if("admin".equals(identity)){
            System.out.println("是管理员");
            return true;
        }
        System.out.println("不是管理员");
        return false;
    }
}
