package com.gin.boot.mybatis.mapper;

import com.gin.boot.mybatis.domain.Clazz;

public interface ClazzMapper {
//    int deleteByPrimaryKey(Integer clazzId);
//
//    int insert(Clazz record);
//
//    int insertSelective(Clazz record);
//
//    Clazz selectByPrimaryKey(Integer clazzId);
//
//    int updateByPrimaryKeySelective(Clazz record);
//
//    int updateByPrimaryKey(Clazz record);

//    根据班级id查询班级
//    @param clazzId 班级id
//    @return 查询到的班级对象

//    Clazz getClazzOneToMany(int clazzId);


//    根据班级id查询班级
//    @param clazzId 班级id
//    @return 查询到的班级对象（班级自身信息、班级教师信息、班级所有学生的信息）
    Clazz getClazz(int clazzId);
}