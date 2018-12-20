package com.xiao.JAVAManito.goodidea.auth.provider;

/**
 * Created by unclexiao on 01/06/2018.
 *
 * 权限check 服务的功能实现接口
 */
public interface AuthServiceProvider {
    boolean isSuitable(String type);
    boolean check(String identity);
}
