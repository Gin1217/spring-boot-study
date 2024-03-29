package com.example.springbootbasic.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author gin
 * @date 2021/3/9
 * @description Child
 */
@Data
@Component
//@ConfigurationProperties(prefix = "family.child")
public class Child {
    private String name;
    private Integer age;
    private List<Map<String,Object>> friends;
}
