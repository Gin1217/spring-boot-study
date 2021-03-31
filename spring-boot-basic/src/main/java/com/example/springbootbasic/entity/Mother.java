package com.example.springbootbasic.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author gin
 * @date 2021/3/9
 * @description Mother
 */

@Data
@Component
//@ConfigurationProperties(prefix = "family.mother")
public class Mother {
    private String name;
    private List<String> alias;
}
