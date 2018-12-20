package com.xiao.JAVAManito.goodidea.auth;


import com.xiao.JAVAManito.goodidea.auth.provider.AuthServiceProvider;

import java.util.Collection;

/**
 * Created by unclexiao on 01/06/2018.
 *
 * 这个接口 只负责 类型的判断，不负责 权限check的具体功能实现
 */
public class AuthServiceImpl implements AuthService {

    private Collection<AuthServiceProvider> providers;

    @Override
    public boolean check(String type,String identity) {

        for(AuthServiceProvider provider : providers){
            if(provider.isSuitable(type)){
                return provider.check(identity);
            }
        }

        return false;
    }
}
