package com.metropolitan.coursemanagementapp.controller;

import com.metropolitan.coursemanagementapp.service.CourseService;
import com.metropolitan.coursemanagementapp.service.RoleService;
import com.metropolitan.coursemanagementapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
@RequiredArgsConstructor
public class CoreController {

    private final UserService userService;
    private final RoleService roleService;
    private final CourseService courseService;

    @GetMapping("/")
    public String getAllUsers(Model model) {
        model.addAttribute("courseList", courseService.getAllCourses());
        return "core/index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "core/register";
    }
}
