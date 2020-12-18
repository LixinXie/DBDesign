package com.xie.dbdesign.service.impl;

import com.xie.dbdesign.entity.Student;
import com.xie.dbdesign.mapper.StudentMapper;
import com.xie.dbdesign.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public Student queryStudentBySno(String userId) {
        return studentMapper.queryStudentBySno(userId);
    }

    @Override
    public List<Student> queryStudentBySname(String sName) {
        return studentMapper.queryStudentBySname(sName);
    }

    @Override
    public List<Student> queryStudentByDno(String dNo) {
        return studentMapper.queryStudentByDno(dNo);
    }
}
