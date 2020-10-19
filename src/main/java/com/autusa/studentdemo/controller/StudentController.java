package com.autusa.studentdemo.controller;

import com.autusa.studentdemo.model.Student;
import com.autusa.studentdemo.service.CourseService;
import com.autusa.studentdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listStudents", studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/shownewstudentform")
    public String showNewStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("courselist", courseService.getAllCourses());
        return "new_student";

    }

    @PostMapping("/savestudent")
    public String saveStudent(@Valid @ModelAttribute() Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_student";
        }
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/showFormforUpdate/{id}")
    public String showFormforUpdate(@PathVariable long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("courselist", courseService.getAllCourses());
        return "update_student";
    }

    @GetMapping("/deletStudent/{id}")
    public String deletStudent(@PathVariable long id) {
        this.studentService.deletStudentById(id);
        return "redirect:/";
    }

}
