package com.example.springbootbasic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gin
 * @date 2021/3/5
 * @description BookReader
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookReader {
    private String name;
    private Integer age;
}
