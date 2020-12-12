package com.xie.dbdesign.entity;


import lombok.Data;
import java.sql.Timestamp;

@Data
public class Course {

    // 课程号
    private String cNo;
    // 课程号
    private String cName;
    // 任课教师号
    private String tNo;
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

}
