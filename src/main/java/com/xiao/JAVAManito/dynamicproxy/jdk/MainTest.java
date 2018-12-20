package com.xiao.JAVAManito.dynamicproxy.jdk;

/**
 * Created by unclexiao on 2017/12/15.
 */
public class MainTest {
    public static void main(String[] args) {

         //目标对象绑定到 代理
        UncleInvocationHandler ui = new UncleInvocationHandler(new UserServiceImpl());

        //由代理对象产生目标对象的实例
        UserService us = (UserService) ui.createProxyInstance();

        //目标对象方法的调用  ---》代理捕获目标对象的方法调用----》由代理对象调用invoke方法真正的去调用目标对象的方法
        us.save("lalala");
        us.getWords();


        //目标对象没有绑定到代理对象，所以这里是目标对象直接调用方法
        UserService us2 = new UserServiceImpl();
        us2.getWords();


    }
}
