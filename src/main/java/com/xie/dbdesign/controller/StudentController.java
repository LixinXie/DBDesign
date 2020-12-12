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

    //获取个人信息重定向到主页
    @RequestMapping(value = "/showStuInfo", method = RequestMethod.GET)
    public String getUserInfo(Model model,@RequestParam("userId") String userId){
        Student stu = studentService.queryStudentBySno(userId);
        Department dept =departmentService.queryDepartmentByDno(stu.getDNo());
        model.addAttribute("student", stu);
        model.addAttribute("department", dept);
        return "studentInfo";
    }

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

    @RequestMapping("/toChooseCourse")
    public String toChooseCourse(){
        return "chooseCourse";
    }

}
