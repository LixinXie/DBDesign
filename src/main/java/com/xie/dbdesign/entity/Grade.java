package com.xie.dbdesign.entity;

import lombok.Data;

@Data
public class Grade {

    // 学号
    private String sNo;
    // 课程号
    private String cNo;
    // 平时成绩
    private double usualGrade;
    // 考试成绩
    private double testGrade;
    // 总评成绩
    private double generalGrade;

}
