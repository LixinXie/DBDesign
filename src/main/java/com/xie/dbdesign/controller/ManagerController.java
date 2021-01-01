package com.xie.dbdesign.controller;

import com.xie.dbdesign.entity.Department;
import com.xie.dbdesign.entity.Student;
import com.xie.dbdesign.entity.Users;
import com.xie.dbdesign.service.DepartmentService;
import com.xie.dbdesign.service.StudentService;
import com.xie.dbdesign.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class ManagerController {

    StudentService studentService;
    UsersService usersService;
    DepartmentService departmentService;

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    // 管理学生
    @RequestMapping("/toManageStudent")
    public String toManageStudent(Model model,
                                  @RequestParam("userId") String userId,
                                  @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "manageStudent";
    }

    // 管理教职工
    @RequestMapping("/toManageTeacher")
    public String toManageTeacher(Model model,
                                  @RequestParam("userId") String userId,
                                  @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "manageTeacher";
    }

    // 管理课程
    @RequestMapping("/toManageCourse")
    public String toManageCourse(Model model,
                                 @RequestParam("userId") String userId,
                                 @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "manageCourse";
    }

    // 管理系别
    @RequestMapping("/toManageDepartment")
    public String toManageDepartment(Model model,
                                     @RequestParam("userId") String userId,
                                     @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "manageDepartment";
    }

    // 跳转到录入学生信息页面
    @RequestMapping("/toAddStudentInfo")
    public String toAddStudentInfo(Model model,
                                   @RequestParam("userId") String userId,
                                   @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "addStudentInfo";
    }

    // 录入学生信息
    @RequestMapping("/addStudentInfo")
    public String addStudentInfo(Model model,
                                 @RequestParam("userId") String userId,
                                 @RequestParam("userType") String userType,
                                 @RequestParam("sNo") String sNo,
                                 @RequestParam("sName") String sName,
                                 @RequestParam("sBirthday") Date sBirthday,
                                 @RequestParam("sSex") String sSex,
                                 @RequestParam("enrollGrade") Double enrollGrade,
                                 @RequestParam("dNo") String dNo,
                                 @RequestParam("sStatus") String sStatus,
                                 @RequestParam("pswd") String pswd){
        // 查询是否存在该学生
        Student temp = studentService.queryStudentBySno(sNo);
        List<Department> departments = departmentService.queryAllDepartment();
        if(temp != null){
            model.addAttribute("addStudentMsg", "已存在该学生,录入失败!");
        }else{
            // 创建新学生
            Student student = new Student();
            student.setSNo(sNo);
            student.setSName(sName);
            student.setSBirthday(sBirthday);
            student.setSSex(sSex);
            student.setEnrollGrade(enrollGrade);
            student.setDNo(dNo);
            student.setSStatus(sStatus);
            // 创建新登录用户
            Users user = new Users();
            user.setUsername(sNo);
            user.setPswd(pswd);
            user.setUsertype("学生");
            if(usersService.addUser(user) > 0 && studentService.addStudent(student) > 0){
                model.addAttribute("addStudentMsg", "录入成功!");
            }else{
                model.addAttribute("addStudentMsg", "录入失败!");
            }
        }
        model.addAttribute("departments", departments);
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "addStudentInfo";
    }

    // 跳转到输入学号修改界面
    @RequestMapping("/toInputSno")
    public String toInputSno(Model model,
                             @RequestParam("userId") String userId,
                             @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "toInputSnoUpdateStudentInfo";
    }

    // 跳转到修改学生信息页面
    @RequestMapping("/toUpdateStudentInfo")
    public String toUpdateStudentInfo(Model model,
                                      @RequestParam("userId") String userId,
                                      @RequestParam("userType") String userType,
                                      @RequestParam("sNo") String sNo){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        Student student = studentService.queryStudentBySno(sNo);
        if(student == null){
            model.addAttribute("msg", "未找到该学生信息!请重新输入学号!");
            return "toInputSnoUpdateStudentInfo";
        }else{
            model.addAttribute("currStudent", student);
        }
        return "updateStudentInfo";
    }

    // 修改学生信息
    @RequestMapping("/updateStudentInfo")
    public String updateStudentInfo(Model model,
                                    @RequestParam("userId") String userId,
                                    @RequestParam("userType") String userType,
                                    @RequestParam("sNo") String sNo,
                                    @RequestParam("sName") String sName,
                                    @RequestParam("sBirthday") Date sBirthday,
                                    @RequestParam("sSex") String sSex,
                                    @RequestParam("enrollGrade") Double enrollGrade,
                                    @RequestParam("dNo") String dNo,
                                    @RequestParam("sStatus") String sStatus,
                                    @RequestParam("pswd") String pswd){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        // 创建新学生对象
        Student student = new Student();
        student.setSNo(sNo);
        student.setSName(sName);
        student.setSBirthday(sBirthday);
        student.setSSex(sSex);
        student.setEnrollGrade(enrollGrade);
        student.setDNo(dNo);
        student.setSStatus(sStatus);
        // 创建新登录用户对象
        Users user = new Users();
        user.setUsername(sNo);
        user.setPswd(pswd);
        user.setUsertype("学生");
        int resUser = usersService.updateUser(user);
        int resStu = studentService.updateStudent(student);
        if(resUser > 0 && resStu > 0){
            model.addAttribute("updateStudentMsg", "修改成功!");
        }else{
            model.addAttribute("updateStudentMsg", "修改失败!");
        }
        model.addAttribute("currStudent", student);
        return "updateStudentInfo";
    }


}
