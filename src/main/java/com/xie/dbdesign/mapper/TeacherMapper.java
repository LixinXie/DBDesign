package com.xie.dbdesign.mapper;

import com.xie.dbdesign.entity.Teacher;

import java.util.List;

public interface TeacherMapper {

    // 增加教职工x信息
    int addTeacher(Teacher teacher);

    // 修改教职工信息
    int updateTeacher(Teacher teacher);

    // 按职工号删除教职工
    int deleteTeacherByTno(String tNo);

    // 按职工号查询教师信息
    Teacher queryTeacherByTno(String tNo);

    // 按姓名查询教师信息
    List<Teacher> queryTeacherByTname(String tName);

    // 按系号查询教师信息
    List<Teacher> queryTeacherByDno(String dNo);



}
