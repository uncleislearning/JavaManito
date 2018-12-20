package com.xiao.JAVAManito.serialization;

import java.io.*;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class SerializeUtils {

    /**
     * Object序列化为二进制流bytes
     * @param o
     * @return
     * @throws IOException
     */
    public static byte[] transportToBytes(Object o) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        ObjectOutputStream objectOut = new ObjectOutputStream(out);

        objectOut.writeObject(o);

        return out.toByteArray();
    }

    /**
     * 二进制bytes反序列化为Object
     * @param ObjectBytes
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object transportToObject(byte[] ObjectBytes) throws IOException, ClassNotFoundException {
            ByteArrayInputStream in = new ByteArrayInputStream(ObjectBytes);
            ObjectInputStream objectInput = new ObjectInputStream(in);

            return objectInput.readObject();
    }



}
