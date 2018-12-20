package com.xiao.JAVAManito.RPC.demo1.server;

import com.xiao.JAVAManito.RPC.demo1.CalculatorService;

/**
 * Created by unclexiao on 19/12/2018.
 * <p>
 * 远程服务端 接口的真正实现类
 */
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public int add(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public int minus(Integer a, Integer b) {
        return a - b;
    }
}
