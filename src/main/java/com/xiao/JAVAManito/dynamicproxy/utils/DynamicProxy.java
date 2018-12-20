package com.xiao.JAVAManito.dynamicproxy.utils;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

/**
 * Created by unclexiao on 11/04/2018.
 */
public class DynamicProxy {
    public static void writeToDisk(String path,String className,Class<?> target) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);

        byte[] bytes = ProxyGenerator.generateProxyClass(className,target.getInterfaces());

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
