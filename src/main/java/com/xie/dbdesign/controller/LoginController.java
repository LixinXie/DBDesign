package com.xie.dbdesign.controller;

import com.xie.dbdesign.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    private UsersService usersService;
    private String uname;
    private String pswd;
    private String userType;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    public String getUname() {
        return uname;
    }


    //到登录界面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    //跳转到主页
    @RequestMapping(value = "/toHome", method = RequestMethod.POST)
    public String login(Model model,
                        @RequestParam("userid") String userid,
                        @RequestParam("pswd") String pwd,
                        @RequestParam("ptype") String ptype){
        this.uname = userid;
        this.pswd = pwd;
        this.userType = ptype;
        String checkpswd = usersService.queryPswdByUname(userid);
        String homePage;
        if(pwd.equals(checkpswd)){//登录成功
            // 将用户名放入model
            model.addAttribute("userId", userid);
            // 将用户类型放入model
            model.addAttribute("userType", ptype);
            switch (ptype){
                case "学生": homePage =  "studentHome"; break;
                case "教职工": homePage = "teacherHome"; break;
                case "管理员": homePage = "managerHome"; break;
                default: homePage = "studentHome"; break;
            }
            return homePage;
        }else{
            model.addAttribute("error", "账号或密码错误");
        }
        return "login";
    }
}
