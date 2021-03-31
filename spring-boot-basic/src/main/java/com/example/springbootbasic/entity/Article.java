package com.example.springbootbasic.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author gin
 * @date 2021/3/8
 * @description Article
 */

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Article {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("作者")
    private String author;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("内容")
    private String content;
    @ApiModelProperty("创建时间")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone
            = "GMT+8")
    private Date updateTime;
    @ApiModelProperty("读者列表")
    private List<ArticleReader> readers;

}
