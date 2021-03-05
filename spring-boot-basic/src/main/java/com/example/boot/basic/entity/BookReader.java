package com.example.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gin
 * @date 2021/3/5
 * @description BookReader
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookReader {
    private String name;
    private Integer age;

}
