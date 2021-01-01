package com.xie.dbdesign.service.impl;

import com.xie.dbdesign.entity.Department;
import com.xie.dbdesign.mapper.DepartmentMapper;
import com.xie.dbdesign.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    DepartmentMapper departmentMapper;

    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public int addDepartment(Department department) {
        return departmentMapper.addDepartment(department);
    }

    @Override
    public int deleteDepartmentByDno(String dNo) {
        return departmentMapper.deleteDepartmentByDno(dNo);
    }

    @Override
    public int updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department);
    }

    @Override
    public Department queryDepartmentByDno(String dNo) {
        return departmentMapper.queryDepartmentByDno(dNo);
    }

    @Override
    public Department queryDepartmentByDname(String dName) {
        return departmentMapper.queryDepartmentByDname(dName);
    }

    @Override
    public List<Department> queryAllDepartment() {
        return departmentMapper.queryAllDepartment();
    }
}
