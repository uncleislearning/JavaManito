package com.xiao.JAVAManito.socket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by unclexiao on 19/12/2018.
 *
 * 半双工通信  客户端
 *
 */
public class ClientTest {
    public static void main(String[] args) throws IOException {

        //1.建立连接
        Socket socket = new Socket("localhost", 7777);

        //2.获取输出流
        OutputStream os = socket.getOutputStream();

        //3.IO
        os.write("请帮忙把桌上的奶酪吃了".getBytes("UTF-8"));

        //4.关闭输出流 注意这里不能使用 os.close() 原因是 该方法会将socket也关闭掉；如果socket关闭了，那么后面基于该socket的流操作均会抛出异常
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        StringBuilder sb = new StringBuilder();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            sb.append(new String(buffer, 0, len, "UTF-8"));
        }
        System.out.println("客户端：已经收到回复");
        System.out.println(sb);

        is.close();
        os.close();

        //可不写，因为socket的流关闭，也会关闭socket
//        socket.close();
    }
}
