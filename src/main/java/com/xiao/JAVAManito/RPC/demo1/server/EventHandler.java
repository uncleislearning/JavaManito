package com.xiao.JAVAManito.RPC.demo1.server;

import com.xiao.JAVAManito.RPC.demo1.Request;
import com.xiao.JAVAManito.RPC.demo1.ServerConfig;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.xiao.JAVAManito.RPC.demo1.server.ServerRPCUtil.*;

/**
 * Created by unclexiao on 19/12/2018.
 * <p>
 * 处理请求的服务   单机版
 */
public class EventHandler {

    private static ServerSocket serverSocket;

    static {
        try {
            serverSocket = new ServerSocket(ServerConfig.getServerPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void eventHandler() throws IOException, ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        while (true) {

            //1.监听请求
            Socket socket = serverSocket.accept();

            //2.IO
            byte[] reqData = receiveReqData(socket.getInputStream());

            //3.反序列化
            Request request = (Request) getRequest(reqData);

            //4.反射得到目标对象
            Object service = getTargetService(request.serviceName, request.serviceVersion);

            //5.反射执行目标方法
            Object result = callTargetMethod(service, request.methodName, request.args, request.argsType);

            //6.结果序列化
            byte[] respData = getRespData(result);

            //7.IO
            tansferRespData(respData, socket.getOutputStream());


            //8.close stream and socket
            closeStreamAndSocket(socket);
        }
    }


}
