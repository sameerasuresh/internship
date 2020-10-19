package com.autusa.studentdemo.controller;

import com.autusa.studentdemo.model.Course;
import com.autusa.studentdemo.repository.CourseRespository;
import com.autusa.studentdemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {

    @Autowired
    private CourseRespository respository;
    @Autowired
    private CourseService courseService;

    @GetMapping("/shownewcourseform")
    public String showNewCourseFomm(Model model) {
        model.addAttribute("course", new Course());
        return "new_course";
    }

    @PostMapping("/savecourse")
    public String saveCourse(@ModelAttribute() Course course) {
        courseService.saveCourse(course);
        return "redirect:/";
    }
}
