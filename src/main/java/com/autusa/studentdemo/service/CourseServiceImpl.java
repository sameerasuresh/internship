package com.autusa.studentdemo.service;

import com.autusa.studentdemo.model.Course;
import com.autusa.studentdemo.repository.CourseRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRespository courseRespository;

    @Override
    public List<Course> getAllCourses() {
        return courseRespository.findAll();
    }

    @Override
    public void saveCourse(Course course) {
        courseRespository.save(course);
    }
}
