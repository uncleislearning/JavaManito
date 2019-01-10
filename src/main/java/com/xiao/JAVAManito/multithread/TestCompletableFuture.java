/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.xiao.JAVAManito.multithread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author xiaomengning
 * @version $Id: TestCompletableFuture.java, v 0.1 2018年12月30日 22:06 xiaomengning Exp $
 */
public class TestCompletableFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //test1();

        //主线程等待 工作线程完成任务
        Thread.sleep(2000L);
    }



    private static void test4(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->"hello");

        //直接消费上一步的结果，无返回值
        future.thenAccept(x-> System.out.println(x));

        future.thenAccept(x-> System.out.println(x+"world"));
    }

    private static void test2() throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            //第一阶段 返回结果
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int a = 1;
            return a + 1;
        });

        //while (!future.isDone()){
        //
        //}
        //如果 线程执行到这里，future还未执行完，那么future最终的结果 用complete的参数来代替
        future.complete(3);

        int res = future.get();

        System.out.println(res);
    }

    private static void test3() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {

            return 12;
        });

        // thenApply : 等待上一步结果完成，再执行一个动作，以上一步结果为参数，但并不会改变上一步的结果
        Integer joinRes = future.thenApply(x -> {
            System.out.println(x);
            return x + 1;
        }).get();

        System.out.println(future.get());

        System.out.println(joinRes);
    }

    private static void test1() {

        //1.注意两者之间的区别，都表示执行一个动作：一个是执行Runnable，一个是执行一个Function

        //CompletableFuture future = CompletableFuture.runAsync(new Runnable() {
        //    @Override
        //    public void run() {
        //        try {
        //            Thread.sleep(1000L);
        //            System.out.println("睡了一秒");
        //            throw new RuntimeException("上一步异常");
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        //    }
        //});

        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L);
                System.out.println("睡了一秒");
                throw new RuntimeException("上一步异常");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return (Void) null;
        });

        //相当于 异常处理
        future.exceptionally(ex -> {
            if (ex instanceof Throwable) {
                System.out.println("参数是一个Throwable");
            }
            System.out.println("error：" + ex);
            return null;
        });
    }
}