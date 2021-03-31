package com.example.book.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author gin
 * @date 2021/3/18
 * @description Book
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//JPA中的实体化类用Entity标注
@Entity
@Table(name="book")
public class Book {

//    用Id标注主键
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    属性名和字段名不一致时用@Column注解
    private String name;
    
    private String cover;
}
