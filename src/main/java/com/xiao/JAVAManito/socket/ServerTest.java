package com.xiao.JAVAManito.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by unclexiao on 19/12/2018.
 * 半双工通信 服务端
 */
public class ServerTest {
    public static void main(String[] args) throws IOException, InterruptedException {

        //1. 启动服务
        ServerSocket serverSocket = new ServerSocket(7777);
        //2. 监听端口
        Socket socket = serverSocket.accept();

        System.out.println("已经建立连接");
        //3. 获取输入流
        InputStream is = socket.getInputStream();
        StringBuilder sb = new StringBuilder();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            sb.append(new String(buffer, 0, len, "UTF-8"));
        }

        System.out.println("服务端：已经收到消息");
        System.out.println(sb);


        System.out.println("服务端：发送消息");

        OutputStream os = socket.getOutputStream();
        os.write("我收到了你的消息，请君安心".getBytes("UTF-8"));

        os.close();
        is.close();
        serverSocket.close();
    }
}
