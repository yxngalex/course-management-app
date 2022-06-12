package com.metropolitan.coursemanagementapp.controller;

import com.metropolitan.coursemanagementapp.entity.User;
import com.metropolitan.coursemanagementapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/admin")
    public String getAllUsers(Model model) {
        model.addAttribute("getUsers", userService.getAllUsers());

        return "admin";
    }

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "register";
    }

    @PostMapping("/save_user")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/";
    }

    @PostMapping(value = "/delete_user/{userId}")
    public String deleteUser(@PathVariable Integer userId) {
        List<User> userList = userService.getAllUsers();
        for (User user : userList) {
            if (user.getId() == userId) {
                userService.deleteById(userId);
            }
        }
        return "redirect:/";
    }

    @GetMapping("/edit_user/{userId}")
    public String editUser(@PathVariable Integer userId, Model model) {
        List<User> userList = userService.getAllUsers();

        for (User user : userList) {
            if (user.getId() == userId) {
                model.addAttribute("user", user);
            }

        }
        return "edit_user";
    }

}
