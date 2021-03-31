package com.gin.boot.mybatis.mapper;

import com.gin.boot.mybatis.domain.Teacher;

public interface TeacherMapper {
//    int deleteByPrimaryKey(Integer teacherId);
//
//    int insert(Teacher record);
//
//    int insertSelective(Teacher record);
//
//    Teacher selectByPrimaryKey(Integer teacherId);
//
//    int updateByPrimaryKeySelective(Teacher record);
//
//    int updateByPrimaryKey(Teacher record);
//
//    List<Teacher> selectAll();



//    根据教师id查询教师的信息（一对一，关联查询出其管理的班级对象信息）
//    @param teacherId 教师id
//    @return teacher对象

    Teacher getTeacherOneByOne(int teacherId);
}