package com.xiao.JAVAManito.goodidea.auth;

/**
 * Created by unclexiao on 01/06/2018.
 *
 *  权限检查：
 *
 *  需求：
 *
 *  需要进行权限检查的具体实例：报表、工作簿等
 *
 *
 *
 * 实现：
 *
 * 简单版：
 *  为每一个实例编写AuthService接口的实现 例如 ReportAuthServiceImpl、WorkBookAuthServiceImpl等
 *  这样带来的问题：为接口的调用方 不便，因为调用方需要进行判断，才能决定调用哪个实现
 *
 *
 *
 * 设计版：
 *
 * AuthService 负责 类型判断并选择哪种权限校验类(简单版这个工作由调用者完成)
 *
 * AuthServiceProvider   负责权限校验
 *
 *
 *
 *  公共的权限检测接口
 */
public interface AuthService {
    boolean check(String type,String identity);
}
