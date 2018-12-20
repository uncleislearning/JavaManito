package com.xiao.JAVAManito.effective;

import java.io.*;

/**
 * Created by unclexiao on 18/05/2018.
 */
public class BestWayCloseResource {


    /**
     *  java 7 引进的 try-with-Resource
     * @param path
     * @return
     * @throws IOException
     */
    public static String firstLineOfFile(String path) {
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
                return br.readLine();
        }catch (IOException e) {
            return "";
        }
    }

    public static void copy(String src,String dest) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(src));
            BufferedWriter bw = new BufferedWriter(new FileWriter(dest))){
            char[] buffer= new char[10];
            int len;
            while ((len = br.read(buffer))>0){
                bw.write(buffer,0,len);
            }
        }
    }
}
