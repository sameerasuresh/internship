package com.autusa.studentdemo.service;

import com.autusa.studentdemo.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    void saveCourse(Course course);
}
