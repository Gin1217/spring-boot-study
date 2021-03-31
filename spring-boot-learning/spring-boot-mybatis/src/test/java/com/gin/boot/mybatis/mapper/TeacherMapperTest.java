package com.gin.boot.mybatis.mapper;

import com.gin.boot.mybatis.domain.Teacher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @author gin
 * @date 2021/3/23
 * @description TeacherMapperTest
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
class TeacherMapperTest {
    @Resource
    private TeacherMapper teacherMapper;

//    @Test
//    void selectAll(){
//        List<Teacher> teachers = teacherMapper.selectAll();
//        System.out.println(teachers);
//    }
//
//    @Test
//    void deleteByPrimaryKey(){
//
//    }

    @Test
    void getTeacherOneByOne(){
        Teacher teacher=teacherMapper.getTeacherOneByOne(1);
        System.out.println(teacher);
    }
}
