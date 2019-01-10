/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.service;

import com.xiao.JAVAManito.framework.dal.Book;

import java.util.List;

/**
 *
 * @author xiaomengning
 * @version $Id: BookService.java, v 0.1 2018年12月25日 21:32 xiaomengning Exp $
 */
public interface BookService {
    void addBook();

    void deleteBook();

    List<Book> getAll();
}