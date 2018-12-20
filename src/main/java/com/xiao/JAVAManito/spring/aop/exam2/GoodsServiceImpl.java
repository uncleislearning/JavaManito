package com.xiao.JAVAManito.spring.aop.exam2;

import com.xiao.JAVAManito.spring.aop.exam1.AdminOnly;
import org.springframework.stereotype.Component;

/**
 * Created by unclexiao on 17/04/2018.
 */
@Component
public class GoodsServiceImpl implements GoodsService {
    @Override
    @AdminOnly
    public void delete() {
        System.out.println("正在删除一个商品");
    }

    @Override
    @AdminOnly
    public void insert() {
        System.out.println("正在添加一个商品");
    }
}
