package com.xie.dbdesign.controller;

import com.xie.dbdesign.entity.Course;
import com.xie.dbdesign.entity.Teacher;
import com.xie.dbdesign.service.CourseService;
import com.xie.dbdesign.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class CourseController {

    private CourseService courseService;
    private TeacherService teacherService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    // 跳转到查询课程信息页面
    @RequestMapping("/toQueryCourseInfo")
    public String toQueryCourseInfo(){
        return "courseInfoQuery";
    }

    // 查询课程信息
    @RequestMapping("/queryCourseInfo")
    public String queryCourseInfo(Model model,
                                  @RequestParam("searchType") String searchType,
                                  @RequestParam("searchText") String searchText){
        List<Course> courses = new ArrayList<>();
        Map<Course, Teacher> map = new HashMap<>();// 存课程和对应的教师
        switch (searchType){
            case "课程号":
                Course course = courseService.queryCourseByCno(searchText);
                if(course == null){ break; }
                Teacher teacher = teacherService.queryTeacherByTno(course.getTNo());
                map.put(course, teacher);
                break;
            case "课程名":
                courses= courseService.queryCourseByCname(searchText);
                break;
            case "任课教师名":
                courses = courseService.queryCourseByTname(searchText);
                break;
            default:break;
        }
        if(searchType.equals("课程名") || searchType.equals("任课教师名")){
            for (Course cours : courses) {
                Teacher t = teacherService.queryTeacherByTno(cours.getTNo());
                map.put(cours, t);
            }
        }
        if(map.size() == 0){
            model.addAttribute("error", "未找到!");
        }
        model.addAttribute("resultMap", map);
        return "courseInfoQuery";
    }

}
