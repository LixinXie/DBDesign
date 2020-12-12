package com.xie.dbdesign.service.impl;

import com.xie.dbdesign.entity.Teacher;
import com.xie.dbdesign.mapper.TeacherMapper;
import com.xie.dbdesign.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    TeacherMapper teacherMapper;

    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public int deleteTeacherByTno(String tNo) {
        return teacherMapper.deleteTeacherByTno(tNo);
    }

    @Override
    public Teacher queryTeacherByTno(String tNo) {
        return teacherMapper.queryTeacherByTno(tNo);
    }

    @Override
    public List<Teacher> queryTeacherByTname(String tName) {
        return teacherMapper.queryTeacherByTname(tName);
    }

    @Override
    public List<Teacher> queryTeacherByDno(String dNo) {
        return teacherMapper.queryTeacherByDno(dNo);
    }
}
