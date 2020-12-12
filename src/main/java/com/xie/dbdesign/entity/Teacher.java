package com.xie.dbdesign.entity;

import lombok.Data;
import java.sql.Date;

@Data
public class Teacher {

    // 职工号
    private String tNo;
    // 姓名
    private String tName;
    // 性别
    private String tSex;
    // 出生日期
    private Date tBirthday;
    // 所在系号
    private String dNo;
    // 职称
    private String tTitle;
    // 专业及教学方向
    private String tMajor;

}
