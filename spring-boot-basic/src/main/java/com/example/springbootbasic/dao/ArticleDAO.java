package com.example.springbootbasic.dao;

import com.example.springbootbasic.entity.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author gin
 * @date 2021/3/18
 * @description Article
 */

@Repository
//数据库的语义化标签
//DAO层用这个，Controller层用Controller，service层用service
public class ArticleDAO {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public Article save(Article article){

//        先在数据库中调通，再复制过来，常量变成变量，用问号占格子
//        另外，sql语句最后都加上空格
        String sql="INSERT INTO article(author,title,content) VALUES(?,?,?) ";
        Object[] args={article.getAuthor(),article.getTitle(),article.getContent()};
//        如果忘记（）里应该放什么类型的数据，将光标停在括号里，按command+p查看
        int count = jdbcTemplate.update(sql, args);
        if (count==1){
            return  article;
        }else {
            return  null;

        }
    }
}
