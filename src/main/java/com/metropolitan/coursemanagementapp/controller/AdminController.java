package com.metropolitan.coursemanagementapp.controller;

import com.metropolitan.coursemanagementapp.entity.Comment;
import com.metropolitan.coursemanagementapp.entity.Course;
import com.metropolitan.coursemanagementapp.entity.Role;
import com.metropolitan.coursemanagementapp.entity.User;
import com.metropolitan.coursemanagementapp.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;
    private final CourseService courseService;
    private final CommentService commentService;
    private final RefundService refundService;

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("getUsers", userService.getAllUsers());
        return "admin/user_table";
    }

    @GetMapping("/add_new_user")
    public String addNewUser(Model model) {
        User user = new User();
        List<Role> roleList = roleService.getAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("roleList", roleList);
        return "admin/add_user";
    }

    @PostMapping("/save_user")
    public String saveUser(@ModelAttribute("user") User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/update_user")
    public String updateUser(@ModelAttribute("user") User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.updateUser(user);

        return "redirect:/admin";
    }

    @PostMapping(value = "/delete_user/{userId}")
    public String deleteUser(@PathVariable Integer userId) {
        userService.deleteById(userId);
        return "redirect:/admin";
    }

    @GetMapping("/edit_user/{userId}")
    public String editUser(@PathVariable Integer userId, Model model) {
        List<User> userList = userService.getAllUsers();
        List<Role> roleList = roleService.getAllRoles();

        for (User user : userList) {
            if (user.getId() == userId) {
                model.addAttribute("user", user);
                model.addAttribute("roleList", roleList);
            }
        }
        return "admin/edit_user";
    }

    @GetMapping("/courses")
    public String getAllCourses(Model model){
        List<Course> courseList = courseService.getAllCourses();
        model.addAttribute("courseList", courseList);
        return "admin/course_table";
    }

    @GetMapping("/course/{id}")
    public String getAllComments(@PathVariable Integer id, Model model){
        List<Comment> commentList = commentService.findAllByCourseId(id);
        model.addAttribute("commentList", commentList);
        return "admin/comment_table";
    }

    @GetMapping("/delete_comment/{id}")
    public String deleteComment(@PathVariable Integer id, Model model){
        commentService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/refunds/")
    public String getAllRefundRequests(Model model){
        model.addAttribute("refundList", refundService.getAllRefunds());
        return "admin/refund_table";
    }

}
