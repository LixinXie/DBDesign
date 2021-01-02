package com.xie.dbdesign.controller;

import com.xie.dbdesign.entity.*;
import com.xie.dbdesign.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ManagerController {

    StudentService studentService;
    UsersService usersService;
    DepartmentService departmentService;
    CourseService courseService;
    TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

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

    // 管理学生#################################################################################################

    // 管理学生
    @RequestMapping("/toManageStudent")
    public String toManageStudent(Model model,
                                  @RequestParam("userId") String userId,
                                  @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "manageStudent";
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

    // 管理课程#################################################################################################

    // 管理课程
    @RequestMapping("/toManageCourse")
    public String toManageCourse(Model model,
                                 @RequestParam("userId") String userId,
                                 @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "manageCourse";
    }

    // 跳转到录入课程信息页面
    @RequestMapping("/toAddCourseInfo")
    public String toAddCourse(Model model,
                              @RequestParam("userId") String userId,
                              @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "addCourseInfo";
    }

    // 录入课程信息
    @RequestMapping("/addCourseInfo")
    public String addCourseInfo(Model model,
                                @RequestParam("userId") String userId,
                                @RequestParam("userType") String userType,
                                @RequestParam("cNo") String cNo,
                                @RequestParam("cName") String cName,
                                @RequestParam("tNo") String tNo,
                                @RequestParam("cHour") Integer cHour,
                                @RequestParam("cCredit") Double cCredit,
                                @RequestParam("cTime") String cTime,
                                @RequestParam("cSite") String cSite,
                                @RequestParam("cTestTime") String cTestTime) throws ParseException {
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        String msg = "";
        Course c = courseService.queryCourseByCno(cNo);
        if(c != null){
            msg = "已存在该课程信息，添加失败!";
        }else{
            Teacher t = teacherService.queryTeacherByTno(tNo);
            if(t == null){
                msg = "不存在该教师，录入失败，请重新输入任课教师号!";
            }else{
                Course course = new Course();
                course.setCNo(cNo);
                course.setCName(cName);
                course.setTNo(tNo);
                course.setCHour(cHour);
                course.setCCredit(cCredit);
                course.setCTime(cTime);
                course.setCSite(cSite);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
                java.util.Date date = simpleDateFormat.parse(cTestTime);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                if(date != null){
                    timestamp = new Timestamp(date.getTime());
                }
                course.setCTestTime(timestamp);
                course.setCSelectedNum(0);
                int res = courseService.addCourse(course);
                if(res > 0){
                    msg = "录入成功!";
                }else{
                    msg = "录入失败!";
                }
            }
        }
        model.addAttribute("addCourseMsg", msg);
        return "addCourseInfo";
    }
    // 跳转到输入课程号修改页面
    @RequestMapping("/toInputCno")
    public String toInputCno(Model model,
                             @RequestParam("userId") String userId,
                             @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "toInputCnoUpdateCourseInfo";
    }

    // 跳转到修改课程信息页面
    @RequestMapping("/toUpdateCourseInfo")
    public String toUpdateCourseInfo(Model model,
                                     @RequestParam("userId") String userId,
                                     @RequestParam("userType") String userType,
                                     @RequestParam("cNo") String cNo){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        Course course = courseService.queryCourseByCno(cNo);
        if(course == null){
            model.addAttribute("msg", "未找到该课程信息!请重新输入课程号!");
            return "toInputCnoUpdateCourseInfo";
        }else{
            Timestamp timestamp = course.getCTestTime();
            LocalDateTime localDateTime = timestamp.toLocalDateTime();
            String testTime = localDateTime.toString();
            model.addAttribute("currCourse", course);
            model.addAttribute("currCourseTestTime", testTime);
        }
        return "updateCourseInfo";
    }

    // 修改课程信息
    @RequestMapping("/updateCourseInfo")
    public String updateCourseInfo(Model model,
                                   @RequestParam("userId") String userId,
                                   @RequestParam("userType") String userType,
                                   @RequestParam("cNo") String cNo,
                                   @RequestParam("cName") String cName,
                                   @RequestParam("tNo") String tNo,
                                   @RequestParam("cHour") Integer cHour,
                                   @RequestParam("cCredit") Double cCredit,
                                   @RequestParam("cTime") String cTime,
                                   @RequestParam("cSite") String cSite,
                                   @RequestParam("cTestTime") String cTestTime,
                                   @RequestParam("cSelectedNum") Integer cSelectedNum) throws ParseException {
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        Teacher t = teacherService.queryTeacherByTno(tNo);
        if(t == null){
            String msg = "不存在该教师，录入失败，请重新输入任课教师号!";
            model.addAttribute("updateCourseMsg", msg);
        }else{
            // 创建新课程对象
            Course course = new Course();
            course.setCNo(cNo);
            course.setCName(cName);
            course.setTNo(tNo);
            course.setCHour(cHour);
            course.setCCredit(cCredit);
            course.setCTime(cTime);
            course.setCSite(cSite);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
            java.util.Date date = simpleDateFormat.parse(cTestTime);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            if(date != null){
                timestamp = new Timestamp(date.getTime());
            }
            course.setCTestTime(timestamp);
            course.setCSelectedNum(cSelectedNum);
            int res = courseService.updateCourse(course);
            if(res > 0){
                model.addAttribute("updateCourseMsg", "修改成功!");
            }else{
                model.addAttribute("updateCourseMsg", "修改失败!");
            }
        }
        return "updateCourseInfo";
    }

    // 管理教职工#################################################################################################

    // 管理教职工
    @RequestMapping("/toManageTeacher")
    public String toManageTeacher(Model model,
                                  @RequestParam("userId") String userId,
                                  @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "manageTeacher";
    }


    // 管理系别#################################################################################################

    // 管理系别
    @RequestMapping("/toManageDepartment")
    public String toManageDepartment(Model model,
                                     @RequestParam("userId") String userId,
                                     @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "manageDepartment";
    }


}
