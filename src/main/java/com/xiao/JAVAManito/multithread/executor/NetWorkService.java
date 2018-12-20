package com.xiao.JAVAManito.multithread.executor;

import java.io.IOException;
import java.net.ServerSocket;

import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by unclexiao on 18/06/2018.
 */
public class NetWorkService  {
    private final ServerSocket serverSocket;
    private final ExecutorService executorPool;

    public NetWorkService(int port,int poolSize) throws IOException {
        serverSocket = new ServerSocket(port);
        executorPool = Executors.newFixedThreadPool(poolSize);
    }

    public void run() throws IOException {
        while (true){
            Socket connection = serverSocket.accept();
            //这里将处理请求 当做一个任务，使用新的线程来异步执行

            //使用线程池来 不断的 执行 "处理请求"这个任务
            executorPool.execute(new RequestHandler(connection));
        }
    }

}
