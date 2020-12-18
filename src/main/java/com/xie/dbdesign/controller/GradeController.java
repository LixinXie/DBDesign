package com.xie.dbdesign.controller;


import com.xie.dbdesign.service.CourseService;
import com.xie.dbdesign.service.GradeService;
import com.xie.dbdesign.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



@Controller
public class GradeController {

    private GradeService gradeService;
    private TeacherService teacherService;
    private CourseService courseService;

    @Autowired
    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }


}
