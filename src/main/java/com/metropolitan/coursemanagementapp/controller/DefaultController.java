package com.metropolitan.coursemanagementapp.controller;

import com.metropolitan.coursemanagementapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DefaultController {

    private final CourseService courseService;

    @GetMapping("/")
    public String getAllCourses(Model model){
        model.addAttribute("courseList", courseService.getAllCourses());
        return "core/index";
    }
}
