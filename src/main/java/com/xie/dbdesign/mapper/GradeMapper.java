package com.xie.dbdesign.mapper;

import com.xie.dbdesign.entity.Grade;

import java.util.List;

public interface GradeMapper {

    // 增加成绩
    int addGrade(Grade grade);

    // 修改成绩
    int updateGrade(Grade grade);

    // 按学号查询学生成绩
    List<Grade> queryGradeBySno(String sNo);

    // 按学生姓名查询成绩
    List<Grade> queryGradeBySname(String sName);

    // 按课程号查询学生成绩
    List<Grade> queryGradeByCno(String cNo);

    // 按课程名查询学生成绩
    List<Grade> queryGradeByCname(String cName);

    // 按上课教师姓名查询学生成绩
    List<Grade> queryGradeByTname(String tName);

    // 按系号查询学生成绩
    List<Grade> queryGradeByDno(String dNo);


}
