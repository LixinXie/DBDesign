package com.xie.dbdesign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QueryInfoController {

    // 回到个人主页
    @RequestMapping(value = "/backHome")
    public String backStuHome(Model model,
                              @RequestParam("userId") String userId,
                              @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        String returnPage = "studentHome";
        switch (userType){
            case "学生":
                returnPage = "studentHome";
                break;
            case "教职工":
                returnPage = "teacherHome";
                break;
            case "管理员":
                returnPage = "managerHome";
                break;
        }
        return returnPage;
    }

    // 跳转到查询各种信息菜单页面
    @RequestMapping("/toQueryInfoHome")
    public String toQueryInfoHome(Model model,
                                  @RequestParam("userId") String userId,
                                  @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "queryInfoHome";
    }

}
