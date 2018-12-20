package com.xiao.JAVAManito.multithread.synchronize;

import org.glassfish.jersey.internal.guava.HashBasedTable;
import sun.management.snmp.jvmmib.JvmThreadInstanceTableMeta;

import javax.management.monitor.Monitor;
import java.lang.ref.SoftReference;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by unclexiao on 30/01/2018.
 */
public class DemoTest implements Runnable {

    static Integer count = new Integer(0);


    public static class Item {

        public String name;

        public Item(String name){
            this.name = name;
        }

        public void hi(){
            System.out.println("没锁 hi");
        }


        public  synchronized String getName(){
            return "对象锁 get";
        }

        public  synchronized void setName(String name){
            System.out.println("对象锁 set");
        }
    }
    public static class MyThread extends Thread{
        public int id;

        public Item a;

        public MyThread(int id,Item a) {
            this.id = id;
            this.a = a;
        }

        public void say(){
            System.out.println("I'm "+id);
        }

        @Override
        public void run() {
//            System.out.println("mythread"+id+"要开始执行同步方法啦");
            for(int i=0;i<5;i++)
              a.hi();
//            System.out.println("mythread"+id+"执行同步方法完啦");
        }
    }



    public static class MyThreadT extends Thread{
        public int id;

        public Item a;

        public MyThreadT(int id,Item a) {
            this.id = id;
            this.a = a;
        }

        public void say(){
            System.out.println("I'm "+id);
        }

        @Override
        public void run() {
//            System.out.println("mythreadt"+id+"要开始执行非同步方法啦");

            for(int i=0;i<5;i++)
            System.out.println(a.getName());
//            System.out.println("mythreadt"+id+"执行非同步方法完啦");
        }
    }



    public  static  void main(String[] args) throws InterruptedException {
        Item item = new Item("one");

        MyThread a = new MyThread(1,item); //调用同步方法
        MyThreadT b = new MyThreadT(2,item); //调用非同步方法

        a.start();
        b.start();


    }

//    @Override
//    public  void run() {
//
//        //锁加在当前对象实例身上，而main主线程中生成的俩子线程，它们拿的都是自己的对象锁，所以同步失败
//        synchronized(this) {
//            for (int i = 0; i < 8; i++) {
//                System.out.println(Thread.currentThread().getName() + ":" + count++);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    //锁还是加在当前对象实例身上，相当于上例
    @Override
    public synchronized void run() {

        for (int i = 0; i < 8; i++) {
            System.out.println(Thread.currentThread().getName() + ":" +i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    //锁加在静态成员上面，锁住的是整个Object的Class类信息
    static  Object lock = new Object();//(成员共享锁)


//    @Override
//    public  void run() {
//        //加锁成功
//        synchronized (lock){
//            for (int i = 0; i < 8; i++) {
//                System.out.println(Thread.currentThread().getName() + ":" + count++);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }












}
