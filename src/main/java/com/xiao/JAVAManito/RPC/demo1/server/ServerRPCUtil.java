package com.xiao.JAVAManito.RPC.demo1.server;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by unclexiao on 19/12/2018.
 */
public class ServerRPCUtil {


    /**
     * 关闭 stream and socket ，
     * 注意这里流的关闭顺序：应该与业务逻辑中 使用的顺序就近关闭，
     * 即如果closeStreamAndSocket方法执行前最后使用的是输出流，则这里先关闭输出流
     *
     * 另外，socket不需要再关闭，因为当socket的任一流关闭之后，socket也会被关闭
     * @param socket
     */
    public static void closeStreamAndSocket(Socket socket) {
        try {
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 向输出流 写入数据
     * @param respData
     * @param outputStream
     * @throws IOException
     */

    public static void tansferRespData(byte[] respData,OutputStream outputStream) throws IOException {
        outputStream.write(respData,0,respData.length);
    }

    /**
     * 序列化请求结果
     * @param result
     * @return
     * @throws IOException
     */
    public static byte[] getRespData(Object result) throws IOException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(result);

        return bos.toByteArray();
    }


    /**
     * 通过反射 调用目标方法
     * @param service
     * @param methodName
     * @param args
     * @param argsType
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    public static Object callTargetMethod(Object service, String methodName, Object[] args,Class[] argsType) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class t = service.getClass();
        Method method = t.getMethod(methodName,argsType);

        return method.invoke(service,args);
    }

    /**
     * 路由找到目标服务的bean
     * @param serviceName
     * @param serviceVersion
     * @return
     */
    public static Object getTargetService(String serviceName, String serviceVersion) {
        return ServerBeanHolder.getBeanByNameAndVersion(serviceName,serviceVersion);
    }

    /**
     * 反序列化请求
     * @param reqData
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object getRequest(byte[] reqData) throws IOException, ClassNotFoundException {
        if (reqData == null || reqData.length==0){
            return null;
        }
        ByteArrayInputStream bis = new ByteArrayInputStream(reqData);
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }


    /**
     * 从输入流中读取数据
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] receiveReqData(InputStream inputStream) throws IOException {
        if(inputStream == null){
            return new byte[0];
        }

        byte[] data;
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes)!=-1){
                bos.write(bytes);
            }
            data = bos.toByteArray();
        }finally {
            if(bos!=null)
                bos.close();
        }
        return data;
    }


}
