package com.xie.dbdesign.service;

import com.xie.dbdesign.entity.Department;

import java.util.List;

public interface DepartmentService {

    // 增加一个系
    int addDepartment(Department department);

    // 按系号删除一个系
    int deleteDepartmentByDno(String dNo);

    // 修改一个系
    int updateDepartment(Department department);

    // 根据系号查询系信息
    Department queryDepartmentByDno(String dNo);

    // 根据系名查询系信息
    Department queryDepartmentByDname(String dName);

    // 查询所有系信息
    List<Department> queryAllDepartment();

}
