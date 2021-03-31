package com.example.book.repository;

import com.example.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {


//    根据书名查找并按id排序
//    @return List<Book>

//    智能的拼单词写代码
//    List<Book> findBookByCoverLike()

}
