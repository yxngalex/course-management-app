package com.metropolitan.coursemanagementapp.controller;

import com.metropolitan.coursemanagementapp.entity.*;
import com.metropolitan.coursemanagementapp.repository.CommentRepository;
import com.metropolitan.coursemanagementapp.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/")
@RequiredArgsConstructor
public class CoreController {

    private final UserService userService;
    private final RoleService roleService;
    private final CourseService courseService;
    private final CommentService commentService;
    private final ReceiptService receiptService;
    private final RefundService refundService;

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
        return "redirect:/login";
    }

    @PostMapping("/bought_courses")
    public String boughtCourses(@RequestParam("username") String username, Model model) {
        User user = userService.getUserByUsername(username);

        List<Receipt> receiptList = receiptService.getAllReceipts();
        List<Course> usersBoughtCourses = new ArrayList<>();
        for(Receipt receipt : receiptList){
            if(receipt.getOrderDetails().getOrder().getUser().getId() == user.getId()){
                usersBoughtCourses.add(receipt.getOrderDetails().getCourse());
            }
        }
        model.addAttribute("courseList", usersBoughtCourses);
        model.addAttribute("comment", "");
        return "core/bought_courses";
    }

    @PostMapping("/bought_courses/refund")
    public String boughtCoursesRefund(@RequestParam("username") String username,
                                      @RequestParam("course") Course course,
                                      @RequestParam("comment") String refundComment) {

        User user = userService.getUserByUsername(username);

        Refund refund = new Refund();

        refund.setRefundComment(refundComment);
        refund.setUser(user);
        refund.setCourse(course);
        refundService.saveRefund(refund);

        return "redirect:/";
    }
}
