package com.autusa.studentdemo.service;

import com.autusa.studentdemo.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void saveStudent(Student student);

    Student getStudentById(long id);

    void deletStudentById(long id);
}
