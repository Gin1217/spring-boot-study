package com.example.springbootbasic.controller;

import com.example.springbootbasic.controller.dto.AjaxResponse;
import com.example.springbootbasic.controller.dto.Param;
import com.example.springbootbasic.entity.Book;
import com.example.springbootbasic.entity.BookReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author gin
 * @date 2021/3/5
 * @description BookController
 */
@RestController
@Slf4j
@RequestMapping(value = "/api/v1/books")
public class BookController {
    @GetMapping("all")
    public AjaxResponse selectBooks() {
        BookReader[] readers = {
                BookReader.builder()
                        .name("qqq")
                        .age(20)
                        .build(),
                BookReader.builder()
                        .name("bbb")
                        .age(19)
                        .build(),
        };
        List<BookReader> readerList = Arrays.asList(readers);
        Book book1 = Book.builder()
                .id(123)
                .author("bbn")
                .title("Springboot")
                .content("SpringBoot从入门到放弃")
                .createdTime(new Date())
                .readers(readerList)
                .build();

        Book book2 = Book.builder()
                .id(456)
                .author("bbn")
                .title("Vue")
                .content("Vue.js")
                .createdTime(new Date())
                .readers(readerList)
                .build();

        Book[] books = {book1,book2};
        List<Book> bookList = Arrays.asList(books);

        return AjaxResponse.success(bookList);
    }

    @GetMapping("{id}")
    public AjaxResponse getBook(@PathVariable int id) {
        Book book = Book.builder()
                .id(id)
                .author("bbn")
                .title("Java")
                .content("Java")
                .createdTime(new Date())
                .build();

        return AjaxResponse.success(book);
    }

    @PostMapping()
    public AjaxResponse saveBook(@RequestBody Book book) {
        log.info("saveBook:" + book);
        return AjaxResponse.success(book);
    }
//    修改,通过问号传参

    @PutMapping()
    public AjaxResponse updateBook(@RequestParam int id, @RequestParam String title) {

        Book book = Book.builder()
                .id(111)
                .author("bbn")
                .title("java")
                .content("java")
                .createdTime(new Date())
                .build();
        book.setId(id);
        book.setTitle(title);
        log.info("book:" + book);
        return AjaxResponse.success(book);
    }


//    @PutMapping()
//    public AjaxResponse updateBook(@RequestBody Book book) {
//
//        Book book1 = Book.builder()
//                .id(111)
//                .author("bbn")
//                .title("java")
//                .content("java")
//                .createdTime(new Date())
//                .build();
//        book.setId(book.getId());
//        book.setTitle(book.getTitle());
//        log.info("book:" + book);
//        return AjaxResponse.success(book);
//    }
    //删除
//    @DeleteMapping("{id}")
//    public  AjaxResponse deleteBook(@PathVariable int id,String title){
//        log.info("id:"+id);
//        return AjaxResponse.success();
//    }

    //删除,表单请求
//    @DeleteMapping()
//     public  AjaxResponse deleteBook( int id,String title){
//        log.info("id:"+id);
//        log.info("title:"+title);
//        return AjaxResponse.success();
//    }

//        @DeleteMapping()
//            public  AjaxResponse deleteBook(@RequestParam(value ="id",defaultValue = "888") int idd,@RequestParam("tit") String tit){
//                log.info("id:"+idd);
//                log.info("title:"+tit);
//                return AjaxResponse.success();
//            }

//    @DeleteMapping() //与以下同理


    @RequestMapping(value = "del",method = RequestMethod.DELETE)
    public AjaxResponse deleteBook(@RequestBody Param param){
        log.info("id:"+param.getId());
        log.info("title:"+param.getTitle());
        return AjaxResponse.success(param);
    }


    //    request是什么类型的对象？
    //    是HttpServletRequest的对象
    @PostMapping("upload")
    public AjaxResponse handleUpload(MultipartFile file, HttpServletRequest request) {

        //创建文件在服务器的存放路径
        String path = request.getServletContext().getRealPath("/upload");
        log.info(path);
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            boolean flag = fileDir.mkdirs();
            log.info("flag:" + flag);
        }

        //生成文件在服务器的名称的前缀
        String prefixName = UUID.randomUUID().toString();
        //取得文件的原文件名
        String originalFilename = file.getOriginalFilename();
        //从原文件名中分离出拓展名（后缀） 111.jpg->jpg
        assert originalFilename != null;
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //拼接新的文件名
        String fileName = prefixName + suffixName;
        log.info(fileName);
        //创建上传的文件对象
        File saveFile = new File(path + "/" + fileName);
        //上传
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            log.info(e.getMessage());
            AjaxResponse.failure("文件上传失败");
        }
        return AjaxResponse.success(fileName);
    }
}
