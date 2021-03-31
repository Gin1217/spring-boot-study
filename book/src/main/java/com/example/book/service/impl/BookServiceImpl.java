package com.example.book.service.impl;

import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;
import com.example.book.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gin
 * @date 2021/3/19
 * @description BookServiceImpl
 */

@Service
@Transactional(rollbackFor={RuntimeException.class})
public class BookServiceImpl implements BookService {

    @Resource
    private BookRepository bookRepository;



    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
