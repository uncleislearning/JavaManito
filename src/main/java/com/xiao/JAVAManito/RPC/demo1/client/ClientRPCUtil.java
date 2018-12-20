package com.xiao.JAVAManito.RPC.demo1.client;

import com.xiao.JAVAManito.RPC.demo1.Request;
import com.xiao.JAVAManito.RPC.demo1.ServerConfig;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * Created by unclexiao on 19/12/2018.
 */
public class ClientRPCUtil {


    /**
     * 反序列 请求结果
     * @param resqData
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */

    public static Object getResult(byte[] resqData) throws IOException, ClassNotFoundException {
        if (resqData == null || resqData.length == 0) {
            return null;
        }
        ByteArrayInputStream bis = new ByteArrayInputStream(resqData);
        ObjectInputStream oio = new ObjectInputStream(bis);

        return oio.readObject();


    }

    /**
     * 读取输入流数据
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] receiveResqData(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] bytes = new byte[1024];

        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            bos.write(bytes);
        }
        bos.flush();
        bos.close();

        return bos.toByteArray();
    }


    /**
     * 向输出流写入数据
     * @param outputStream
     * @param reqData
     * @throws IOException
     */
    public static void transferReqData(OutputStream outputStream, byte[] reqData) throws IOException {
        if (outputStream == null || reqData == null || reqData.length == 0) {
            return;
        }

        outputStream.write(reqData);
    }

    /**
     * 关闭连接 见 server端的关闭连接
     * 注意，这里不需要再关闭输出流，原因是前面代码已经关闭了shutdownOutput
     * @param socket
     */
    public static void closeStreamAndSocket(Socket socket) {
        try {
            InputStream is = socket.getInputStream();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 序列化 请求对象
     * @param request
     * @return
     * @throws IOException
     */
    public static byte[] genReqData(Request request) throws IOException {

        if (request == null) {
            return new byte[0];
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(request);

        return bos.toByteArray();
    }


    public static int getServerPort(String serviceName) {
        return ServerConfig.getServerPort();
    }

    /**
     * 路由
     *
     * @param addresses
     * @return
     */
    public static String getTargetAddress(List<String> addresses) {
        if (CollectionUtils.isEmpty(addresses)) {
            throw new IllegalArgumentException();
        }

        return addresses.get(0);
    }

    /**
     * 寻址
     * @param
     * @return
     */
    public static List<String> getAvailableAddresses(String serviceName) {
        return ServerConfig.getServerAddress();
    }
}
