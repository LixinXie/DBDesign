package com.xie.dbdesign.controller;

import com.xie.dbdesign.entity.Teacher;
import com.xie.dbdesign.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TeacherController {

    TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    // 跳转到查询教职工信息页面
    @RequestMapping("/toQueryTeacherInfo")
    public String toQueryTeacherInfo(Model model,
                                     @RequestParam("userId") String userId,
                                     @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "teacherInfoQuery";
    }
    // 查询教师信息
    @RequestMapping("/queryTeacherInfo")
    public String queryTeacherInfo(Model model,
                                   @RequestParam("searchType") String searchType,
                                   @RequestParam("searchText") String searchText,
                                   @RequestParam("userType") String userType){
        List<Teacher> teachers = new ArrayList<>();
        switch (searchType){
            case "职工号":
                Teacher teacher = teacherService.queryTeacherByTno(searchText);
                if(teacher == null){ break; }
                teachers.add(teacher);
                break;
            case "姓名":
                teachers = teacherService.queryTeacherByTname(searchText);
                break;
            case "系号":
                teachers = teacherService.queryTeacherByDno(searchText);
                break;
            default:break;
        }
        if(teachers.size() == 0){
            model.addAttribute("error", "未找到!");
        }
        model.addAttribute("teachers", teachers);
        model.addAttribute("userType", userType);
        return "teacherInfoQuery";
    }


}
