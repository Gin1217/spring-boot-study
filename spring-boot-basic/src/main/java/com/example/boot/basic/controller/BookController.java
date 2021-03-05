package com.example.boot.basic.controller;

import com.example.boot.basic.controller.dto.AjaxResponse;
import com.example.boot.basic.entity.BookReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gin
 * @date 2021/3/5
 * @description BookController
 */
@RestController
@RequestMapping(value = "/api/v1/books")
@Slf4j
public class BookController {

    @GetMapping("all")
    public AjaxResponse selectBooks() {
        BookReader[] readers = {
                BookReader.builder()
                        .name("aaa")
                        .age(20)
                        .build(),
                BookReader.builder()
                        .name("bbb")
                        .age(19)
                        .build(),
        };
        return AjaxResponse.success();
    }


}
