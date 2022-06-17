package com.metropolitan.coursemanagementapp.controller;

import com.metropolitan.coursemanagementapp.entity.Comment;
import com.metropolitan.coursemanagementapp.entity.Course;
import com.metropolitan.coursemanagementapp.entity.Role;
import com.metropolitan.coursemanagementapp.entity.User;
import com.metropolitan.coursemanagementapp.repository.CommentRepository;
import com.metropolitan.coursemanagementapp.service.CommentService;
import com.metropolitan.coursemanagementapp.service.CourseService;
import com.metropolitan.coursemanagementapp.service.RoleService;
import com.metropolitan.coursemanagementapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/")
@RequiredArgsConstructor
public class CoreController {

    private final UserService userService;
    private final RoleService roleService;
    private final CourseService courseService;
    private final CommentService commentService;

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

    @GetMapping("/view/{id}")
    public String viewCourse(@PathVariable Integer id, Model model){
        List<Comment> commentList = commentService.findAllByCourseId(id);
        Comment comment = new Comment();
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        model.addAttribute("commentList", commentList);
        model.addAttribute("comment", comment);

        return "core/view";
    }

    @PostMapping("/comment")
    public String comment(@RequestParam("course") Course course, @RequestParam("comment") String comment, @RequestParam("username") String username){
        Comment userComment = new Comment();
        userComment.setComment(comment);
        userComment.setCourse(course);
        userComment.setUser(userService.getUserByUsername(username));

        commentService.saveComment(userComment);

        return "redirect:/view/" + course.getId();
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
