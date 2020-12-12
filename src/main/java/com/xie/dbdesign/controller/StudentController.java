package com.xie.dbdesign.controller;

import com.xie.dbdesign.entity.Course;
import com.xie.dbdesign.entity.Department;
import com.xie.dbdesign.entity.Grade;
import com.xie.dbdesign.entity.Student;
import com.xie.dbdesign.service.CourseService;
import com.xie.dbdesign.service.DepartmentService;
import com.xie.dbdesign.service.GradeService;
import com.xie.dbdesign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    private String uname;
    private String userType;
    private StudentService studentService;
    private DepartmentService departmentService;
    private GradeService gradeService;
    private CourseService courseService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Autowired
    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    // 获取个人信息跳转到个人信息页
    @RequestMapping(value = "/showStuInfo", method = RequestMethod.GET)
    public String getUserInfo(Model model,@RequestParam("userId") String userId, String cName){
        Student stu = studentService.queryStudentBySno(userId);
        Department dept =departmentService.queryDepartmentByDno(stu.getDNo());
        model.addAttribute("student", stu);
        model.addAttribute("department", dept);
        return "stuAInfo";
    }

    // 获取学生个人成绩信息跳转到学生成绩信息页
    @RequestMapping(value = "/showStuGrade", method = RequestMethod.GET)
    public String toStuGradeInfoSite(Model model, @RequestParam("userId") String sNo){
        List<Grade> grades = gradeService.queryGradeBySno(sNo);
        List<Course> courses = new ArrayList<>();
        for (Grade grade : grades) {
            courses.add(courseService.queryCourseByCno(grade.getCNo()));
        }
        model.addAttribute("stuGrades", grades);
        model.addAttribute("stuCourse", courses);
        return "stuGradeInfo";
    }

    // 跳转到查询选课页面
    @RequestMapping("/toChooseCourse")
    public String toChooseCourse(){
        return "chooseCourse";
    }

    // 跳转到查询各种信息页面
    @RequestMapping("/toQueryInfoHome")
    public String toQueryInfoHome(@RequestParam("userType") String userType){
        return "queryInfoHome";
    }

    // 跳转到查询学生信息页面
    @RequestMapping("/toQueryStudentInfo")
    public String toQueryStudentInfo(){
        return "studentInfoQuery";
    }

    // 查询学生信息
    @RequestMapping("/queryStudentInfo")
    public String queryStudentInfo(Model model,
                                   @RequestParam("searchType") String searchType,
                                   @RequestParam("searchText") String searchText){
        List<Student> res = new ArrayList<>();
        switch (searchType){
            case "学号":
                Student student = studentService.queryStudentBySno(searchText);
                if(student == null){ break; }
                res.add(student);
                break;
            case "姓名":
                res = studentService.queryStudentBySname(searchText);
                break;
            case "系号":
                res = studentService.queryStudentByDno(searchText);
                break;
            default:break;
        }
        if(res.size() == 0){
            model.addAttribute("error", "未找到!");
        }
        model.addAttribute("result", res);
        return "studentInfoQuery";
    }

}
