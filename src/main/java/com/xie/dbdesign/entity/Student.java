package com.xie.dbdesign.entity;


import lombok.Data;
import java.sql.Date;

@Data
public class Student {

    // 学号
    private String sNo;
    // 姓名
    private String sName;
    // 出生日期
    private Date sBirthday;
    // 性别
    private String sSex;
    // 入学成绩
    private double enrollGrade;
    // 所在系号
    private String dNo;
    // 学生状态
    private String sStatus;

}
