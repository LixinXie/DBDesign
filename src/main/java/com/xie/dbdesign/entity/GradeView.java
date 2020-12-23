package com.xie.dbdesign.entity;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class GradeView {

    // 学号
    private String sNo;
    // 姓名
    private String sName;
    // 性别
    private String sSex;
    // 所在系号
    private String dNo;
    // 系名称
    private String dName;
    // 课程号
    private String cNo;
    // 课程名
    private String cName;
    // 任课教师名
    private String tName;
    // 学时
    private int cHour;
    // 学分
    private double cCredit;
    // 上课时间
    private String cTime;
    // 上课地点
    private String cSite;
    // 考试时间
    private Timestamp cTestTime;
    // 平时成绩
    private double usualGrade;
    // 考试成绩
    private double testGrade;
    // 总评成绩
    private double generalGrade;

}
