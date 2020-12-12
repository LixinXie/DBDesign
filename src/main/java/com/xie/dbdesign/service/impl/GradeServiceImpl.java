package com.xie.dbdesign.service.impl;

import com.xie.dbdesign.entity.Grade;
import com.xie.dbdesign.mapper.GradeMapper;
import com.xie.dbdesign.service.GradeService;

import java.util.List;

public class GradeServiceImpl implements GradeService {

    GradeMapper gradeMapper;

    public void setGradeMapper(GradeMapper gradeMapper) {
        this.gradeMapper = gradeMapper;
    }

    @Override
    public int addGrade(Grade grade) {
        return gradeMapper.addGrade(grade);
    }

    @Override
    public int updateGrade(Grade grade) {
        return gradeMapper.updateGrade(grade);
    }

    @Override
    public List<Grade> queryGradeBySno(String sNo) {
        return gradeMapper.queryGradeBySno(sNo);
    }

    @Override
    public List<Grade> queryGradeBySname(String sName) {
        return gradeMapper.queryGradeBySname(sName);
    }

    @Override
    public List<Grade> queryGradeByCno(String cNo) {
        return gradeMapper.queryGradeByCno(cNo);
    }

    @Override
    public List<Grade> queryGradeByCname(String cName) {
        return gradeMapper.queryGradeByCname(cName);
    }

    @Override
    public List<Grade> queryGradeByTname(String tName) {
        return gradeMapper.queryGradeByTname(tName);
    }

    @Override
    public List<Grade> queryGradeByDno(String dNo) {
        return gradeMapper.queryGradeByDno(dNo);
    }
}
