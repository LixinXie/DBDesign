package com.xie.dbdesign.service;

import com.xie.dbdesign.entity.GradeView;

import java.util.List;

public interface GradeViewService {

    // 按学号查询学生成绩
    List<GradeView> queryGradeViewBySno(String sNo);

    // 按学生姓名查询成绩
    List<GradeView> queryGradeViewBySname(String sName);

    // 按课程号查询学生成绩
    List<GradeView> queryGradeViewByCno(String cNo);

    // 按课程名查询学生成绩
    List<GradeView> queryGradeViewByCname(String cName);

    // 按上课教师姓名查询学生成绩
    List<GradeView> queryGradeViewByTname(String tName);

    // 按系号查询学生成绩
    List<GradeView> queryGradeViewByDno(String dNo);

    // 查询所有成绩
    List<GradeView> queryALLGradeView();

}
