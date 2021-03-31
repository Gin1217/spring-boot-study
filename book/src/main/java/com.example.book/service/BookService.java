package com.example.book.service;

import com.example.book.entity.Book;

import java.util.List;

/**
 * @author gin
 * @date 2021/3/19
 * @description BookService
 */
public interface BookService {

//    新增book
//    @param book入参
//    @return 新增的book对象


    Book save(Book book);

//    查询所有的book
//    @return图书合集

    List<Book> getAll();
}
