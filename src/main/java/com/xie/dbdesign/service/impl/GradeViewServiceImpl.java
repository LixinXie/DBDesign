package com.xie.dbdesign.service.impl;

import com.xie.dbdesign.entity.GradeView;
import com.xie.dbdesign.mapper.GradeViewMapper;
import com.xie.dbdesign.service.GradeViewService;

import java.util.List;

public class GradeViewServiceImpl implements GradeViewService {

    private GradeViewMapper gradeViewMapper;

    public void setGradeViewMapper(GradeViewMapper gradeViewMapper) {
        this.gradeViewMapper = gradeViewMapper;
    }

    @Override
    public List<GradeView> queryGradeViewBySno(String sNo) {
        return gradeViewMapper.queryGradeViewBySno(sNo);
    }

    @Override
    public List<GradeView> queryGradeViewBySname(String sName) {
        return gradeViewMapper.queryGradeViewBySname(sName);
    }

    @Override
    public List<GradeView> queryGradeViewByCno(String cNo) {
        return gradeViewMapper.queryGradeViewByCno(cNo);
    }

    @Override
    public List<GradeView> queryGradeViewByCname(String cName) {
        return gradeViewMapper.queryGradeViewByCname(cName);
    }

    @Override
    public List<GradeView> queryGradeViewByTname(String tName) {
        return gradeViewMapper.queryGradeViewByTname(tName);
    }

    @Override
    public List<GradeView> queryGradeViewByDno(String dNo) {
        return gradeViewMapper.queryGradeViewByDno(dNo);
    }

    @Override
    public List<GradeView> queryALLGradeView() {
        return gradeViewMapper.queryALLGradeView();
    }
}
