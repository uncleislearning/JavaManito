package com.xiao.JAVAManito.multithread.executor;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by unclexiao on 18/06/2018.
 */
public class RequestHandler implements Runnable {

    private final Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //处理请求连接的方法
            socket.getOutputStream().write("western".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
