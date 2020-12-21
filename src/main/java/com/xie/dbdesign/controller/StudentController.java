package com.xie.dbdesign.controller;

import com.xie.dbdesign.entity.*;
import com.xie.dbdesign.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    private StudentService studentService;
    private DepartmentService departmentService;
    private GradeService gradeService;
    private CourseService courseService;
    private TeacherService teacherService;

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

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }



    // 获取个人信息跳转到个人信息页
    @RequestMapping(value = "/showStuInfo", method = RequestMethod.GET)
    public String getUserInfo(Model model, @RequestParam("userId") String userId, String cName){
        Student stu = studentService.queryStudentBySno(userId);
        Department dept = null;
        if(stu != null){
            dept =departmentService.queryDepartmentByDno(stu.getDNo());
        }
        model.addAttribute("student", stu);
        model.addAttribute("department", dept);
        return "stuAInfo";
    }

    // 获取学生个人成绩信息跳转到学生成绩信息页
    @RequestMapping(value = "/showStuGrade", method = RequestMethod.GET)
    public String toStuGradeInfoSite(Model model, @RequestParam("userId") String userId){
        List<Grade> grades = gradeService.queryGradeBySno(userId);
        List<Course> courses = new ArrayList<>();
        for (Grade grade : grades) {
            courses.add(courseService.queryCourseByCno(grade.getCNo()));
        }
        model.addAttribute("userId", userId);
        model.addAttribute("stuGrades", grades);
        model.addAttribute("stuCourse", courses);
        return "stuGradeInfo";
    }

    // 获取所有课程和所选课程的Model对象
    private Model getAllCourseAndSelectedCourse(String userId){
        Model model = new ExtendedModelMap();
        // 查询所有可选的课程信息
        List<Course> allCourses = courseService.queryAllCourse();
        Map<Course, Teacher> allCourseMap = new HashMap<>();
        if(allCourses != null && allCourses.size() != 0){
            for (Course course : allCourses) {
                Teacher t = teacherService.queryTeacherByTno(course.getTNo());
                allCourseMap.put(course, t);
            }
        }

        // 查询所选所有课成绩信息
        List<Grade> selectedCourseGrades = gradeService.queryGradeBySno(userId);
        // 查询所选所有课信息
        List<Course> selectedCourses = new ArrayList<>();
        for (Grade selectedCourseGrade : selectedCourseGrades) {
            Course c = courseService.queryCourseByCno(selectedCourseGrade.getCNo());
            if(c != null){
                selectedCourses.add(c);
            }
        }
        // 将课程与教师映射
        Map<Course, Teacher> selectedCourseMap = new HashMap<>();
        if(selectedCourses != null && selectedCourses.size() != 0){
            for (Course selectedCourse : selectedCourses) {
                Teacher t = teacherService.queryTeacherByTno(selectedCourse.getTNo());
                selectedCourseMap.put(selectedCourse, t);
            }
        }
        model.addAttribute("allCourseMap", allCourseMap);
        model.addAttribute("selectedCourseMap", selectedCourseMap);
        return model;
    }

    // 跳转到个人选课页面
    @RequestMapping("/toSelectCourse")
    public String toSelectCourse(Model model,
                                 @RequestParam("userId") String userId){
        // 将学号放入model
        model.addAttribute("userId", userId);
        // 已获得学分
        double gotCredits = 0;
        if(gradeService.queryGottenCredits(userId) != null){
            gotCredits = gradeService.queryGottenCredits(userId);
        }
        model.addAttribute("gotCredits", gotCredits);
        Model temp = getAllCourseAndSelectedCourse(userId);
        if(temp != null){
            model.addAttribute("allCourseMap", temp.getAttribute("allCourseMap"));
            model.addAttribute("selectedCourseMap", temp.getAttribute("selectedCourseMap"));
        }
        return "selectCourse";
    }

    // 选课
    @RequestMapping("/select")
    public String selectIt(Model model,
                           @RequestParam(value = "userId") String userId,
                           @RequestParam(value = "cNo") String cNo){
        // 将学号放入model
        model.addAttribute("userId", userId);
        // 获取当前已选课和所有可选课信息
        Model temp = getAllCourseAndSelectedCourse(userId);
        if(temp != null){
            model.addAttribute("allCourseMap", temp.getAttribute("allCourseMap"));
            model.addAttribute("selectedCourseMap", temp.getAttribute("selectedCourseMap"));
        }
        // 已选课学分
        double gotCredits = 0;
        if(gradeService.queryGottenCredits(userId) != null){
            gotCredits = gradeService.queryGottenCredits(userId);
        }
        model.addAttribute("gotCredits", gotCredits);

        // 查询所选所有课成绩信息
        List<Grade> selectedCourseGrades = gradeService.queryGradeBySno(userId);
        // 查询所选所有课信息
        List<Course> selectedCourses = new ArrayList<>();
        for (Grade selectedCourseGrade : selectedCourseGrades) {
            Course c = courseService.queryCourseByCno(selectedCourseGrade.getCNo());
            if(c != null){
                selectedCourses.add(c);
            }
        }
        // 当前点击选课的课程
        Course currCourse = courseService.queryCourseByCno(cNo);
        // 判断当前点击选课的课程是否已选
        boolean hasSelected = false;
        for (Course seCourse : selectedCourses) {
            String seCno = seCourse.getCNo();
            if (currCourse.getCNo().equals(seCno)) {
                hasSelected = true;
                break;
            }
        }
        // 已选
        if(hasSelected){
            model.addAttribute("selectMsg", "选课失败!此课已选!");
        }
        // 未选，但学分达上限
        else if(gotCredits + currCourse.getCCredit() > 15){
            model.addAttribute("selectMsg", "选课失败!已选课学分已达15分!");
        }else{// 可选
            Grade grade = new Grade();
            grade.setSNo(userId);
            grade.setCNo(cNo);
            grade.setUsualGrade(0);
            grade.setTestGrade(0);
            grade.setGeneralGrade(0);
            // 增加选课记录
            int res = gradeService.addGrade(grade);
            // 已选课学分修改
            if(gradeService.queryGottenCredits(userId) != null){
                gotCredits = gradeService.queryGottenCredits(userId);
            }
            model.addAttribute("gotCredits", gotCredits);
            // 获取当前选课信息
            temp = getAllCourseAndSelectedCourse(userId);
            if(temp != null){
                model.addAttribute("allCourseMap", temp.getAttribute("allCourseMap"));
                model.addAttribute("selectedCourseMap", temp.getAttribute("selectedCourseMap"));
            }
            if(res > 0){// 选课成功
                model.addAttribute("selectMsg", "ok");
            }else{// 选课失败
                model.addAttribute("selectMsg", "选课失败!");
            }
        }
        return "selectCourse";
    }

    // 退选
    @RequestMapping("/deselect")
    public String deSelectIt(Model model,
                             @RequestParam(value = "userId") String userId,
                             @RequestParam(value = "cNo") String cNo){
        // 将学号放入model
        model.addAttribute("userId", userId);
        // 删除选课记录
        int res = gradeService.deleteGradeBySnoCno(userId, cNo);
        // 已选课学分
        double gotCredits = 0;
        if(gradeService.queryGottenCredits(userId) != null){
            gotCredits = gradeService.queryGottenCredits(userId);
        }
        model.addAttribute("gotCredits", gotCredits);
        Model temp = getAllCourseAndSelectedCourse(userId);
        if(temp != null){
            model.addAttribute("allCourseMap", temp.getAttribute("allCourseMap"));
            model.addAttribute("selectedCourseMap", temp.getAttribute("selectedCourseMap"));
        }
        if(res > 0){
            model.addAttribute("deSelectMsg", "ok");
        }else{
            model.addAttribute("deSelectMsg", "退课失败!");
        }
        return "selectCourse";
    }

    // 跳转到查询学生信息页面
    @RequestMapping("/toQueryStudentInfo")
    public String toQueryStudentInfo(Model model,
                                     @RequestParam("userId") String userId,
                                    @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "studentInfoQuery";
    }

    // 查询学生信息
    @RequestMapping("/queryStudentInfo")
    public String queryStudentInfo(Model model,
                                   @RequestParam("searchType") String searchType,
                                   @RequestParam("searchText") String searchText,
                                   @RequestParam("userType") String userType){
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
        model.addAttribute("userType", userType);
        return "studentInfoQuery";
    }

}
