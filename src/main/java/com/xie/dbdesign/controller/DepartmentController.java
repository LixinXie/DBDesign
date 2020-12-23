package com.xie.dbdesign.controller;

import com.xie.dbdesign.entity.Department;
import com.xie.dbdesign.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartmentController {

    DepartmentService departmentService;

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // 跳转到查询系信息页面
    @RequestMapping("/toQueryDepartmentInfo")
    public String toQueryDepartmentInfo(Model model,
                                        @RequestParam("userId") String userId,
                                        @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "departmentInfoQuery";
    }

    // 查询系信息
    @RequestMapping("queryDepartmentInfo")
    public String queryDepartmentInfo(Model model,
                                      @RequestParam("searchType") String searchType,
                                      @RequestParam("searchText") String searchText,
                                      @RequestParam("userId") String userId,
                                      @RequestParam("userType") String userType){
        List<Department> departments = new ArrayList<>();
        switch (searchType){
            case "系号":
                Department department = departmentService.queryDepartmentByDno(searchText);
                if(department == null){ break; }
                departments.add(department);
                break;
            case "系名":
                department = departmentService.queryDepartmentByDname(searchText);
                if(department == null){ break; }
                departments.add(department);
                break;
            default:break;
        }
        if(departments.size() == 0){
            model.addAttribute("error", "未找到!");
        }
        model.addAttribute("departments", departments);
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "departmentInfoQuery";
    }
}
