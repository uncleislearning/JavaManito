package com.xiao.JAVAManito.RPC.demo1.server;

import com.xiao.JAVAManito.RPC.demo1.CalculatorService;

import java.io.IOException;

/**
 * Created by unclexiao on 19/12/2018.
 * 远程服务端 接口的真正实现类 版本2
 */
public class CalculatorServiceImplV2 implements CalculatorService {
    @Override
    public int add(Integer a, Integer b) throws IOException, ClassNotFoundException {
        int c = a+b;
        return c;
    }

    @Override
    public int minus(Integer a, Integer b) throws IOException, ClassNotFoundException {
        int c = a - b;
        return c;
    }
}
