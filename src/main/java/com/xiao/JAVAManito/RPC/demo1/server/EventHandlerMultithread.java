package com.xiao.JAVAManito.RPC.demo1.server;

import com.xiao.JAVAManito.RPC.demo1.Request;
import com.xiao.JAVAManito.RPC.demo1.ServerConfig;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.xiao.JAVAManito.RPC.demo1.server.ServerRPCUtil.*;

/**
 * Created by unclexiao on 19/12/2018.
 * <p>
 * 处理请求的服务   多线程版
 */
public class EventHandlerMultithread {

    private static ServerSocket serverSocket;

    private static ExecutorService threadPool;

    static {
        try {
            serverSocket = new ServerSocket(ServerConfig.getServerPort());
            threadPool = Executors.newFixedThreadPool(10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void eventHandler() throws IOException, ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        while (true) {
            //1.监听请求
            Socket socket = serverSocket.accept();

            threadPool.execute(new HandleTask(socket));
        }
    }



    private static class HandleTask implements Runnable{

        private Socket socket;

        public HandleTask(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
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

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


}
