package com.xie.dbdesign.controller;

import com.xie.dbdesign.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {

    TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    // 跳转到查询教职工信息页面
    @RequestMapping("/toQueryTeacherInfo")
    public String toQueryTeacherInfo(){
        return "teacherInfoQuery";
    }
}
