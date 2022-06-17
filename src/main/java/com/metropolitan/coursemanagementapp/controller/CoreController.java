package com.metropolitan.coursemanagementapp.controller;

import com.metropolitan.coursemanagementapp.entity.Role;
import com.metropolitan.coursemanagementapp.entity.User;
import com.metropolitan.coursemanagementapp.service.CourseService;
import com.metropolitan.coursemanagementapp.service.RoleService;
import com.metropolitan.coursemanagementapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        User user = new User();
        List<Role> roleList = roleService.getAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("roleList", roleList);
        return "core/register";
    }

    @PostMapping("/save_user")
    public String saveUser(@ModelAttribute("user") User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userService.saveUser(user);
        System.out.println(user);
        return "redirect:/login";
    }
}
