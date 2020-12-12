package com.xie.dbdesign.service;

import com.xie.dbdesign.entity.Course;

import java.util.List;

public interface CourseService {

    // 增加一门课程
    int addCourse(Course course);

    // 根据课程号删除一门课程
    int deleteCourseByCno(String cNo);

    // 修改一门课程
    int updateCourse(Course course);

    // 根据课程号查询一门课程
    Course queryCourseByCno(String cNo);

    // 根据课程名查询一门课程
    List<Course> queryCourseByCname(String cName);

    // 根据上课教师姓名查询课程基本信息
    List<Course> queryCourseByTname(String tName);

}
