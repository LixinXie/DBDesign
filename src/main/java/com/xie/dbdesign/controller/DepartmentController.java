package com.xie.dbdesign.controller;

import com.xie.dbdesign.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepartmentController {

    DepartmentService departmentService;

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // 跳转到查询系信息页面
    @RequestMapping("/toQueryDepartmentInfo")
    public String toQueryDepartmentInfo(){
        return "departmentInfoQuery";
    }
}
