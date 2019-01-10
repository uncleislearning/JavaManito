/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 * 加载的工具类
 * @author xiaomengning
 * @version $Id: ClassUtil.java, v 0.1 2018年12月26日 20:03 xiaomengning Exp $
 */
public final class ClassUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

    /**
     * 获取类加载器
     */

    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 加载类
     *
     * isInitialized 是否执行被加载类的静态代码块
     *
     *
     * @param className     全限定类名 com.xiao.JAVAManito.framework.dal.Book
     */
    public static Class<?> loadClass(String className,boolean isInitialized){
        Class<?> cls = null;
        try {
            Class.forName(className,isInitialized,getClassLoader());
        } catch (ClassNotFoundException e) {
            LOGGER.error("load class failure",e);
            throw  new RuntimeException(e);
        }
        return cls;
    }

    /**
     * 加载类
     *
     * isInitialized 是否执行被加载类的静态代码块
     *
     *
     * @param className     全限定类名 com.xiao.JAVAManito.framework.dal.Book
     */
    public static Class<?> loadClass(String className){
       return loadClass(className,false);
    }

    /**
     * 加载指定包名下所有类
     *
     * 列出指定包下所有类文件的全限定类名
     *
     *
     * 包 -- 》 目录
     *
     * 类文件 --》 文件
     *
     * 利用File类可以遍历指定目录下所有的文件
     *
     *
     * @param packageName  com.xiao.JAVAManito.framework
     * @return
     */
    public static Set<Class<?>> loadClassSet(String packageName){
        Set<Class<?>> classSet = new HashSet<>();

        try {
            Enumeration<URL> urls =  getClassLoader().getResources(packageName.replace(".","/"));
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                if(url!=null){
                    String protocol = url.getProtocol();
                    if(protocol.equals("file")){
                        String packagePath = url.getPath().replaceAll("%20"," ");
                        addClass(classSet,packagePath,packageName);
                    }else if(protocol.equals("jar")){
                         JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                         JarFile jarFile= jarURLConnection.getJarFile();
                         if(jarFile!=null){
                             Enumeration<JarEntry>  jarEntries = jarFile.entries();
                             while (jarEntries.hasMoreElements()){
                                 JarEntry jarEntry = jarEntries.nextElement();
                                 String jarEntryName = jarEntry.getName();
                                 if(jarEntryName.endsWith(".class")){
                                     String className = jarEntryName.substring(0,jarEntryName.lastIndexOf(".")).replaceAll("/",".");
                                     doAddClass(classSet,className);
                                 }
                             }
                         }
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.error("load class failure",e);
            throw new RuntimeException(e);
        }

        return classSet;
    }

    private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName) {
        File[] files = new File(packagePath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile()&& file.getName().endsWith(".class") || file.isDirectory();
            }
        });

        for(File file:files){
            String fileName = file.getName();
            if(file.isFile()){
                String className = fileName.substring(0,fileName.lastIndexOf("."));
                if(StringUtils.isNotBlank(packageName)){
                    className = packageName + "." + className;
                }
                doAddClass(classSet,className);
            }else {
                String subPackagePath = fileName;
                if(StringUtils.isNotBlank(packagePath)){
                    subPackagePath = packagePath + "/" + subPackagePath;
                }

                String subPackageName = fileName;
                if(StringUtils.isNotBlank(packagePath)){
                    subPackageName = packagePath + "." + subPackageName;
                }
                addClass(classSet,subPackagePath,subPackageName);
            }
        }


    }

    private static void doAddClass(Set<Class<?>> classSet, String className) {
        Class<?> cls = loadClass(className,false);
        classSet.add(cls);
    }

    public static void main(String[] args) {
        Set<Class<?>> classSet =  loadClassSet("com.xiao.JAVAManito.framework.dal");
        System.out.println(classSet.toArray());
    }

}