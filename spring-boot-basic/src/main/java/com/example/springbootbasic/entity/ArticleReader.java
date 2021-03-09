package com.example.springbootbasic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gin
 * @date 2021/3/8
 * @description ArticleReader
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleReader {

    private String name;
    private Integer age;
}
