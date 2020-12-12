package com.xie.dbdesign.mapper;

import com.xie.dbdesign.entity.Student;

import java.util.List;

public interface StudentMapper {

    // 增加一名学生
    int addStudent(Student student);

    // 修改学生信息
    int updateStudent(Student student);

    // 按学号查询学生信息
    Student queryStudentBySno(String sNo);

    // 按姓名查询学生信息
    List<Student> queryStudentBySname(String sName);

    // 按系号查询学生信息
    List<Student> queryStudentByDno(String dNo);


}
