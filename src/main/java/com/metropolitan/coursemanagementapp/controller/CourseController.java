package com.metropolitan.coursemanagementapp.controller;

import com.metropolitan.coursemanagementapp.entity.Course;
import com.metropolitan.coursemanagementapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get_all")
    public String getAllCourses(Model model){
        model.addAttribute("courseList", courseService.getAllCourses());
        return "index";
    }

    @GetMapping("/show_new_course_form")
    public String showNewUserForm(Model model){
        Course course = new Course();
        model.addAttribute("course", course);
        return "new_course";
    }

    @PostMapping(value = "/delete_course/{id}")
    public String deleteCourse(@PathVariable Integer id){
        courseService.deleteById(id);
        return "redirect:/new_course";
    }

    @PostMapping("/save_course")
    public String saveCourse(@ModelAttribute("course") Course course){
        courseService.saveCourse(course);
        return "redirect:/new_course";
    }

    @GetMapping("/show_update_course_form/{id}")
    public String showEditCourseForm(@PathVariable Integer id, Model model){
        model.addAttribute("course", courseService.getCourseById(id));
        return "edit_course";
    }
}
