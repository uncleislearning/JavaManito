package com.xiao.JAVAManito.multithread;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

/**
 * Created by unclexiao on 2017/11/19.
 */
public class MainTest {

    private static Number number = new Number(100);

    public static void main(String[] args) throws InterruptedException {
//        1.Thread类
//        CountThread c1 = new CountThread("A",number);
//        CountThread c2 = new CountThread("B",number);
//
//        c1.start();
//        c2.start();


        //2.Runnable接口
//        MyRunnable runnable = new MyRunnable();
//        Thread hand = new Thread(runnable);
//        hand.start();

//       3.FutureTask类
        FutureTask ft = new FutureTask(new Callable() {
            public Object call() throws Exception {
                int sum=0;
               for(int i=0;i<5;i++){
                   Thread.sleep(1000);
                   sum+=i;
                }
                return sum;
            }
        });

       Thread t = new Thread(ft);
       t.start();

//       do{
//   do something other,let this thread do its works alone,
// and you can get the result by using get() to rearch when you want to see the result
        // this is the meaning of multithreading !
//       }while (!ft.isDone());

        try {
            int res  = (Integer) ft.get();  //获取异步执行的结果
            System.out.println(res);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        Thread thread = new Thread(()-> System.out.println("1"));


        thread.start();
       // ArrayList

    }




}
