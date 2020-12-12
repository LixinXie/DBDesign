package com.xie.dbdesign.service.impl;

import com.xie.dbdesign.entity.Course;
import com.xie.dbdesign.mapper.CourseMapper;
import com.xie.dbdesign.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private CourseMapper courseMapper;

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    @Override
    public int deleteCourseByCno(String cNo) {
        return courseMapper.deleteCourseByCno(cNo);
    }

    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    @Override
    public Course queryCourseByCno(String cNo) {
        return courseMapper.queryCourseByCno(cNo);
    }

    @Override
    public List<Course> queryCourseByCname(String cName) {
        return courseMapper.queryCourseByCname(cName);
    }

    @Override
    public List<Course> queryCourseByTname(String tName) {
        return courseMapper.queryCourseByTname(tName);
    }
}
