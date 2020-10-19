package com.autusa.studentdemo.repository;

import com.autusa.studentdemo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRespository extends JpaRepository<Course, Long> {
}
