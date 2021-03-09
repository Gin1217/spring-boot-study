package com.example.springbootbasic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author gin
 * @date 2021/3/9
 * @description FileSize  文件大小的配置读取类
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class FileSize {

    @Value("${spring.servlet.multipart.max-file-size}")
    private String maxSize;

}
