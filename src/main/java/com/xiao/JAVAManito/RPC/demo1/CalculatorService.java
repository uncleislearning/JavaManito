package com.xiao.JAVAManito.RPC.demo1;

import java.io.IOException;

/**
 * Created by unclexiao on 19/12/2018.
 * <p>
 * 模拟 RPC的调用过程。这里是一个接口服务
 */
public interface CalculatorService {

    /**
     * 计算 a + b
     *
     * @param a
     * @param b
     * @return
     */
    int add(Integer a, Integer b) throws IOException, ClassNotFoundException;


    /**
     * 计算  a - b
     *
     * @param a
     * @param b
     * @return
     */
    int minus(Integer a, Integer b) throws IOException, ClassNotFoundException;
}
