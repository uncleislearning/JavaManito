package com.xiao.JAVAManito.dynamicproxy.jdk.review;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.*;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Created by unclexiao on 10/04/2018.
 */
public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {


        Student s = new StudentImpl();

        //InvocationHandler实例，最后会被传入代理类实例
        MyInvocationHandler handler = new MyInvocationHandler(s);

        //动态生成 被代理类的具体实现，编译期无法确定  传入具体子类的Classloader
        Student proxy =(Student) Proxy.newProxyInstance(s.getClass().getClassLoader()
                ,s.getClass().getInterfaces(),handler);

        //代理类会通过调用InvocationHandler实例的invoke方法间接调用目标对象的方法
        proxy.hi();

        //将代理类的字节码写到磁盘
        writeToDisk("src/main/$Proxy0.class");
    }



    public static void writeToDisk(String path) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",StudentImpl.class.getInterfaces());

        FileOutputStream out = null;

        try{
            out = new FileOutputStream(new File(path));
            out.write(bytes);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
