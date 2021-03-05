package com.example.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author gin
 * @date 2021/3/5
 * @description Book
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    private String author;
    private String title;
    private String content;
    private Date creatTime;
    private List<BookReader> readers;
}
