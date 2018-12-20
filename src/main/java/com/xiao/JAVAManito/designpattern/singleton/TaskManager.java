package com.xiao.JAVAManito.designpattern.singleton;

/**
 * Created by unclexiao on 2017/12/17.
 */
public class TaskManager {
    private TaskManager() {
    }

//    private static TaskManager tm;
//    public static TaskManager getInstance(){
//        if(tm == null){
//            tm = new TaskManager();
//        }
//        return tm;
//    }

    //饿汉模式
//    private static final TaskManager tm = new TaskManager();
//    public static TaskManager getInstance(){
//        return tm;
//    }
    //懒汉模式
//    private volatile static TaskManager tm;
//    public static TaskManager getInstance(){
//        if(tm == null){
//            synchronized (TaskManager.class){
//                //为什么需要双重判断？当A等待B释放锁，B创建完tm对象，即释放锁，A并不知道tm对象已经创建，如果不做tm==null判断，那么仍会存在单例对象不唯一的情况
//                if(tm == null){
//                    tm = new TaskManager();
//                }
//            }
//        }
//        return tm;
//    }

    //饿汉模式不能延迟加载、懒汉模式延迟加载却需要处理复杂的多线程加锁问题
    //IoDH 技术

    private static class ClassHolder{
        private final static TaskManager tm = new TaskManager();
    }

    public static TaskManager getInstance(){
        return ClassHolder.tm;
    }
}
