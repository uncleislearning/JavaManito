package com.xiao.JAVAManito.RPC.demo1.client;

import com.xiao.JAVAManito.RPC.demo1.CalculatorService;
import com.xiao.JAVAManito.RPC.demo1.Request;

import static com.xiao.JAVAManito.RPC.demo1.client.ClientRPCUtil.*;

import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * Created by unclexiao on 19/12/2018.
 *
 */
public class CalculatorServiceRPCClient implements CalculatorService {

    private static final String serviceName = "CalculatorService";

    @Override
        public int add(Integer a, Integer b) throws IOException, ClassNotFoundException {


        //1.获取服务地址
        List<String> addresses = getAvailableAddresses(serviceName);

        //2.确定目标机器地址
        String address = getTargetAddress(addresses);

        //3.获取服务端口
        int port = getServerPort(serviceName);

        //4.建立连接
        Socket client = new Socket(address, port);

        //5.构造请求
        Request request = new Request(serviceName, "1", "add", new Object[]{a, b},new Class[]{Integer.class,Integer.class});

        //6.序列化请求
        byte[] reqData = genReqData(request);

        //7.发送请求
        transferReqData(client.getOutputStream(),reqData);

        //只有客户端输出流关闭，服务端输入流那边才会读到-1
        client.shutdownOutput();

        //8.接收结果
        byte[] resqData = receiveResqData(client.getInputStream());


        //9.解析结果  反序列
        Object res = getResult(resqData);

        //10. close stream and socket
        closeStreamAndSocket(client);

        return (int)res;
    }



    @Override
    public int minus(Integer a, Integer b) throws IOException, ClassNotFoundException {


        //1.获取服务地址   最小粒度为方法
        List<String> addresses = getAvailableAddresses(serviceName);

        //2.确定目标机器地址
        String address = getTargetAddress(addresses);

        //3.获取服务端口
        int port = getServerPort(serviceName);

        //4.建立连接
        Socket client = new Socket(address, port);

        //5.构造请求  不同
        Request request = new Request(serviceName, "1", "minus", new Object[]{a, b},new Class[]{Integer.class,Integer.class});

        //6.序列化请求
        byte[] reqData = genReqData(request);


        //7.发送请求
        transferReqData(client.getOutputStream(),reqData);

        //只有客户端输出流关闭，服务端输入流那边才会读到-1
        client.shutdownOutput();

        //8.接收结果
        byte[] resqData = receiveResqData(client.getInputStream());

        //9.解析结果
        Object res = getResult(resqData);

        //10. close stream and socket
        closeStreamAndSocket(client);

        return (int) res;
    }
}
