package com.example.springbootbasic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

/**
 * @author gin
 * @date 2021/3/9
 * @description Father
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
@Validated
public class Father {
//    @Value("${family.father.name}")
    private String name;
//    @Value("${family.father.age}")
    @Min(20)
    private Integer age;
}
