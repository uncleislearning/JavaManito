package com.xiao.JAVAManito.RPC.demo1;

import com.xiao.JAVAManito.RPC.demo1.client.CalculatorServiceRPCClient;

import java.io.IOException;

/**
 * Created by unclexiao on 19/12/2018.
 * 模拟 客户端调用
 */
public class AppClientTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        multi();
        single();
    }


    //模拟 客户端调用，单线程调用

    private static void single() throws IOException, ClassNotFoundException {

        CalculatorService client = new CalculatorServiceRPCClient();

        int res = 0;
        res = client.add(1, 1);
        System.out.println(res);


        res = client.minus(1, 1);
        System.out.println(res);
    }


    //模拟 客户端调用, 多线程调用

    private static void multi() throws IOException, ClassNotFoundException {

        CalculatorService client = new CalculatorServiceRPCClient();
        Thread t1 = new Thread(new CallAddTask(client));
        Thread t2 = new Thread(new CallMinusTask(client));
        t1.start();
        t2.start();
    }

    /**
     * 模拟调用add的任务
     */
    private static class CallAddTask implements Runnable {

        private CalculatorService client;

        public CallAddTask(CalculatorService client) {
            this.client = client;
        }

        @Override
        public void run() {
            int res = 0;
            try {
                res = client.add(1, 1);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(res);

        }
    }


    /**
     * 模拟 调用 minus方法的 任务
     */
    private static class CallMinusTask implements Runnable {

        private CalculatorService client;

        public CallMinusTask(CalculatorService client) {
            this.client = client;
        }

        @Override
        public void run() {
            int res = 0;
            try {
                res = client.minus(1, 1);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(res);

        }
    }
}
