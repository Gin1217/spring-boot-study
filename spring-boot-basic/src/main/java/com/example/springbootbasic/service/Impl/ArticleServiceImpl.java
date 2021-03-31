package com.example.springbootbasic.service.Impl;

import com.example.springbootbasic.dao.ArticleDAO;
import com.example.springbootbasic.entity.Article;
import com.example.springbootbasic.service.ArticleService;

import javax.annotation.Resource;

/**
 * @author gin
 * @date 2021/3/18
 * @description ArticleServiceImpl
 */
public class ArticleServiceImpl implements ArticleService {
   @Resource
   private ArticleDAO articleDAO;

    @Override
    public boolean postArticle(Article article) {
        Article saveArticle = articleDAO.save(article);

        //模拟可能出现的异常
//        ……你咋不异常捏？？
        int a =  3 / 0;
        //       更简洁的写法
       return saveArticle !=null;

    }
}
