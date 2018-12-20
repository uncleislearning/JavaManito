package com.xiao.JAVAManito.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by unclexiao on 14/06/2018.
 *
 *
 * 使用FutureTask执行需要提前计算好的任务
 */
public class PreLoader {

    private  final FutureTask<String> future = new  FutureTask<String>(new Callable<String>() {
        @Override
        public String call() throws Exception {
            return loadString();
        }
    });

    // 用来执行这个预热任务

    private final Thread thread = new Thread(future);


    //计算量大的动作

    private String loadString(){
        for(int i=0;i<10000000;i++){

        }
        return "预热数据";
    }


    //启动任务

    public void start(){
        thread.start();
    }

    //获取预热的数据

    public String get() throws ExecutionException, InterruptedException {
        return future.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        PreLoader pre = new PreLoader();

        //启动预热任务
        pre.start();

        for(int i=1;i<10;i++){

        }

        long start = System.currentTimeMillis();
        String data = pre.get();
        long end = System.currentTimeMillis();
        System.out.println((end-start)+":"+data);

    }





}
