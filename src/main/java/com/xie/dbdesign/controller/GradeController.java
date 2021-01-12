package com.xie.dbdesign.controller;


import com.xie.dbdesign.entity.Grade;
import com.xie.dbdesign.entity.GradeView;
import com.xie.dbdesign.service.CourseService;
import com.xie.dbdesign.service.GradeService;
import com.xie.dbdesign.service.GradeViewService;
import com.xie.dbdesign.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class GradeController {

    private GradeService gradeService;
    private TeacherService teacherService;
    private CourseService courseService;
    private GradeViewService gradeViewService;

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

    @Autowired
    public void setGradeViewService(GradeViewService gradeViewService) {
        this.gradeViewService = gradeViewService;
    }

    // 到成绩管理页面
    @RequestMapping("/toManageGrade")
    public String toManageGrade(Model model,
                                @RequestParam("userId") String userId,
                                @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "manageGrade";
    }

    // 到录入成绩页面
    @RequestMapping("/toAddGrade")
    public String toAddGrade(Model model,
                             @RequestParam("userId") String userId,
                             @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "addGrade";
    }

    // 录入成绩
    @RequestMapping("/addGrade")
    public String addGrade(Model model,
                           @RequestParam("userId") String userId,
                           @RequestParam("userType") String userType,
                           @RequestParam("sNo") String sNo,
                           @RequestParam("cNo")String cNo,
                           @RequestParam("usualGrade") double usualGrade,
                           @RequestParam("testGrade") double testGrade,
                           @RequestParam("generalGrade") double generalGrade){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        Grade grade = new Grade();
        boolean uGrade = false;
        boolean tGrade = false;
        boolean gGrade = false;
        boolean canAdd = false;
        if(usualGrade >= 0 && usualGrade <= 100){
            uGrade = true;
        }
        if(testGrade >=0 && testGrade <= 100){
            tGrade = true;
        }
        if(generalGrade >=0 && generalGrade <= 100){
            gGrade = true;
        }
        if(uGrade && tGrade && gGrade){
            grade.setSNo(sNo);
            grade.setCNo(cNo);
            grade.setUsualGrade(usualGrade);
            grade.setTestGrade(testGrade);
            grade.setGeneralGrade(generalGrade);
            Grade temp = gradeService.queryGradeBySnoCno(sNo, cNo);
            if(temp == null){// 选课表没有此记录
                canAdd = true;
            }
        }
        int res = 0;
        if(canAdd){
            res = gradeService.addGrade(grade);
        }
        if(res > 0){
            model.addAttribute("addGradeMsg", "录入成功!");
        }else{
            model.addAttribute("addGradeMsg", "录入失败!");
        }
        return "addGrade";
    }

    // 输入学号课程号
    @RequestMapping("/toInputSnoCno")
    public String toInputSnoCno(Model model,
                                @RequestParam("userId") String userId,
                                @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "toInputSnoCnoUpdateGrade";
    }

    // 跳转到更新成绩页面
    @RequestMapping("/toUpdateGrade")
    public String toUpdateGrade(Model model,
                                @RequestParam("userId") String userId,
                                @RequestParam("userType") String userType,
                                @RequestParam("sNo") String sNo,
                                @RequestParam("cNo") String cNo){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        Grade temp = gradeService.queryGradeBySnoCno(sNo, cNo);
        if(temp == null){
            model.addAttribute("msg", "不存在该选课记录!无法修改!");
            return "toInputSnoCnoUpdateGrade";
        }
        model.addAttribute("currGrade", temp);
        return "updateGrade";
    }

    // 更新成绩
    @RequestMapping("/updateGrade")
    public String updateGrade(Model model,
                              @RequestParam("userId") String userId,
                              @RequestParam("userType") String userType,
                              @RequestParam("sNo") String sNo,
                              @RequestParam("cNo") String cNo,
                              @RequestParam("usualGrade") double usualGrade,
                              @RequestParam("testGrade") double testGrade,
                              @RequestParam("generalGrade") double generalGrade){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        Grade curr = gradeService.queryGradeBySnoCno(sNo, cNo);
        if(curr != null){
            curr.setUsualGrade(usualGrade);
            curr.setTestGrade(testGrade);
            curr.setGeneralGrade(generalGrade);
            int res = gradeService.updateGrade(curr);
            if(res > 0){
                model.addAttribute("msg", "修改成功!");
            }else{
                model.addAttribute("msg", "修改失败!");
            }
        }
        model.addAttribute("currGrade", curr);
        return "updateGrade";
    }

    // 跳转到查询成绩页面
    @RequestMapping("/toQueryGradeInfo")
    public String toQueryGradeInfo(Model model,
                                   @RequestParam("userId") String userId,
                                   @RequestParam("userType") String userType){
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "gradeInfoQuery";
    }

    @RequestMapping("/queryGradeInfo")
    public String queryGradeInfo(Model model,
                                 @RequestParam("userId") String userId,
                                 @RequestParam("userType") String userType,
                                 @RequestParam("searchType") String searchType,
                                 @RequestParam("searchText") String searchText){
        List<GradeView> res = new ArrayList<>();
        List<GradeView> temp;
        switch (searchType){
            case "学号":
                temp = gradeViewService.queryGradeViewBySno(searchText);
                for (GradeView grade : temp) {
                    if(grade != null){
                        res.add(grade);
                    }
                }
                break;
            case "学生姓名":
                temp = gradeViewService.queryGradeViewBySname(searchText);
                for (GradeView grade : temp) {
                    if(grade != null){
                        res.add(grade);
                    }
                }
                break;
            case "课程号":
                temp = gradeViewService.queryGradeViewByCno(searchText);
                for (GradeView grade : temp) {
                    if(grade != null){
                        res.add(grade);
                    }
                }
                break;
            case "课程名称":
                temp = gradeViewService.queryGradeViewByCname(searchText);
                for (GradeView grade : temp) {
                    if(grade != null){
                        res.add(grade);
                    }
                }
                break;
            case "任课教师名":
                temp = gradeViewService.queryGradeViewByTname(searchText);
                for (GradeView grade : temp) {
                    if(grade != null){
                        res.add(grade);
                    }
                }
                break;
            case "系号":
                temp = gradeViewService.queryGradeViewByDno(searchText);
                for (GradeView grade : temp) {
                    if(grade != null){
                        res.add(grade);
                    }
                }
                break;
            default:break;
        }
        if(res.size() == 0){
            model.addAttribute("error", "未找到!");
        }
        model.addAttribute("GradeResult", res);
        model.addAttribute("userId", userId);
        model.addAttribute("userType", userType);
        return "gradeInfoQuery";
    }

}
