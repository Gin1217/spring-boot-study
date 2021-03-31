package com.example.springbootbasic.service;

import com.example.springbootbasic.entity.Article;
import org.springframework.stereotype.Service;

/**
 * @author gin
 * @date 2021/3/18
 * @description ArticleService
 */
@Service
public interface ArticleService {

//    发布文章
//    @param article 文章实体
//    @return boolean

    boolean postArticle(Article article);
}
