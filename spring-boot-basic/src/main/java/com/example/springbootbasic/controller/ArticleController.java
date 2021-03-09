package com.example.springbootbasic.controller;

import com.example.springbootbasic.controller.dto.AjaxResponse;
import com.example.springbootbasic.entity.Article;
import com.example.springbootbasic.entity.ArticleReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author gin
 * @date 2021/3/8
 * @description ArticleController
 */

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/articles")
@Api(tags = "⽂章管理接⼝")
public class ArticleController {
    /**
     * 查询⽂章，id为URL查询参数
     *
     * @param id ⽂章id
     * @return AjaxResponse
     */
    @ApiOperation("URL传参，根据id获取⽂章")
    @GetMapping()
    public AjaxResponse getArticleByParam(@ApiParam("⽂章id") @RequestParam("id") int id) {
        ArticleReader[] readers = {
                ArticleReader.builder().name("aaa").age(20).build(),
                ArticleReader.builder().name("bbb").age(19).build()};
        List<ArticleReader> readerList = Arrays.asList(readers);
        Article article = Article.builder()
                .id(id)
                .author("Gin")
                .title("Spring Boot从⼊⻔到放弃")
                .content("Spring Boot从⼊⻔到放弃")
                .createTime(new Date())
                .readers(readerList)
                .build();
        log.info("article: " + article);
        return AjaxResponse.success(article);
    }
    /**
     * 增加⼀篇Article ，@RequestParam接收参数
     *
     * @param id         id
     * @param author     作者
     * @param title      标题
     * @param content    内容
     * @param createTime 创建时间
     * @return AjaxResponse
     */
    @ApiOperation("URL传参新增⽂章")
    @PostMapping("param")
    public AjaxResponse saveArticle(
            @ApiParam("⽂章id")
            @RequestParam(value = "id", defaultValue = "111", required = false) int id,
            @ApiParam("作者")
            @RequestParam(value = "author", defaultValue = "bbn", required = false) String author,
            @ApiParam("标题")
            @RequestParam String title,
            @ApiParam("内容")
            @RequestParam String content,
            @ApiParam("创建时间")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @RequestParam(value = "createTime", defaultValue = "2021-03-06 12:12:12", required = false)

                    Date createTime) {

        Article article = Article.builder()
                .id(id)
                .title(title)
                .content(content)
                .author(author)
                .createTime(createTime)
                .build();
        log.info("saveArticle:" + article);
        return AjaxResponse.success(article);
    }
    /**
     * 增加⼀篇Article @RequestParam取得表单对象序列化的字符串
     *
     * @param formData 表单对象序列化的字符串
     * @return AjaxResponse
     */
    @ApiOperation("表单请求体新增⽂章")
    @PostMapping("form")
    public AjaxResponse saveArticleByFormData(@ApiParam("表单字符串") @RequestParam("formData") String formData) {
        //表单传递的数据为字符串
        log.info("formData:" + formData);
        //⽤Jackson的反序列化将字符串转为Java对象
        ObjectMapper objectMapper = new ObjectMapper();
        Article article = null;
        try {
            article = objectMapper.readValue(formData, Article.class);
            log.info("article:" + article);
        } catch (
                JsonProcessingException e) {
            e.printStackTrace();
        }
        return AjaxResponse.success(article);
    }
}

//@RestController

//@RequestMapping(value = "/api/v1/article")

//@Slf4j

//public class ArticleController {

//

//    /**

//     * 增加⼀篇Article ，使⽤POST⽅法(RequestBody⽅式接收参数)

//     *

//     * @param article ⽂章实体

//     * @return AjaxResponse

//     */

//    @PostMapping("body")

//    public AjaxResponse saveArticle(@RequestBody Article article) {

//        log.info("saveArticle:" + article);

//        return AjaxResponse.success(article);

//    }

//

//    /**

//     * 增加⼀篇Article ，@RequestParam接收参数

//     *

//     * @param id id,⾮必需，默认值

//     * @param author 作者,⾮必需，默认值

//     * @param title 标题，必需

//     * @param content 内容，必需

//     * @param createTime 创建时间,⾮必需，默认值

//     * @return AjaxResponse

//     */

//    @PostMapping("param")

//    public AjaxResponse saveArticle(

//            @RequestParam(value = "id", defaultValue =

//                    "111", required = false) int id,

//            @RequestParam(value = "author", defaultValue =

//                    "bbn", required = false) String author,

//            @RequestParam String title,

//            @RequestParam String content,

//            @DateTimeFormat(pattern = "yyyy-MM-dd " +

//                    "HH:mm:ss")

//                    @RequestParam(value = "createTime",

//                    defaultValue = "2021-03-06 14:32:12",required = false) Date

//                    createTime) {

//        Article article = Article.builder()

//                .id(id)

//                .title(title)

//                .content(content)

//                .author(author)

//                .createTime(createTime)

//                .build();

//        log.info("saveArticle:" + article);

//        return AjaxResponse.success(article);

//    }

//

//    /**

//     * 增加⼀篇Article @RequestParam取得表单对象序列化的字符串

//     * @param formData 表单对象序列化的字符串

//     * @return AjaxResponse

//     */

//

//    @PostMapping("form")

//    public AjaxResponse

//    saveArticleByFormData(@RequestParam("formData") String

//                                  formData) {

//        //表单传递的数据为字符串

//        log.info("formData:" + formData);

//        //⽤Jackson的反序列化将字符串转为Java对象

//        ObjectMapper objectMapper = new ObjectMapper();

//        Article article = null;

//        try {

//            article = objectMapper.readValue(formData,

//                    Article.class);

//            log.info("article:" + article);

//        } catch (

//                JsonProcessingException e) {

//            e.printStackTrace();

//        }

//        return