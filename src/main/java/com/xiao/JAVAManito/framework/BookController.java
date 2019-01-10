/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework;

import com.xiao.JAVAManito.framework.annotations.Action;
import com.xiao.JAVAManito.framework.annotations.Controller;
import com.xiao.JAVAManito.framework.annotations.Injection;
import com.xiao.JAVAManito.framework.dal.Book;
import com.xiao.JAVAManito.framework.service.BookService;

import java.util.List;

/**
 * @author xiaomengning
 * @version $Id: BookController.java, v 0.1 2018年12月25日 21:31 xiaomengning Exp $
 */

/**
 * @Controller 框架自动扫描，并创建bean，进行生命周期管理
 */
@Controller
public class BookController {

    /**
     *  @Injection 框架自动注入依赖 （DI）
     */
    @Injection
    private BookService bookService;

    /**
     *
     * @Action   框架自动"导航"，将请求转发到目标对象、目标方法上进行执行
     */
    @Action("get:/show_list")
    public Result showList(){
        List<Book>  books = bookService.getAll();
        return ResultFactory.buildData(books);
    }



}