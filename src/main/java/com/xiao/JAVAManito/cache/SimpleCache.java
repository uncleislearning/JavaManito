package com.xiao.JAVAManito.cache;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by unclexiao on 17/06/2018.
 *
 * 应用型 缓存： 在某种应用场景下加缓存
 *
 * 对某一个计算结果（同样的输入，一定得到同样的输出）进行缓存
 */
public class SimpleCache {

    //1. 选用线程安全的集合类

    private final Map<String,Future> cache = Maps.newConcurrentMap();

    public  Object compute(String input) throws InterruptedException, ExecutionException {
        Future result = cache.get(input);
        if(result == null){
            Callable computing = new Callable() {
                @Override
                public Object call() throws Exception {
                    return computing(input);
                }
            };
            //为了防止并发时重复计算，使用了FutureTask，只会有一个线程（第一次到来的线程）在计算，其他线程会阻塞在get方法
            FutureTask ft = new FutureTask(computing);

            // 如果缓存中为null，说明之前没有线程放入过；否则就说明已经有线程放入过相应的值，则当前线程不再重复放入
            result = cache.putIfAbsent(input,ft);
            if(result == null){
                //仅仅第一次放入缓存时才进行计算
                result = ft;
                ft.run();
            }

        }

        try {
            return result.get();
        } catch (InterruptedException e) {
            //如果计算被取消 应该删除缓存中的对象
            cache.remove(input);
            throw e;
        } catch (ExecutionException e) {
            throw e;
        }
    }



    private Object computing(String input) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input.length();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String a = "asdgg";
        SimpleCache cache = new SimpleCache();
        int len1 = (int) cache.compute(a);
        System.out.println(len1);


        int len2 = (int) cache.compute(a);
        System.out.println(len2);


    }

}
