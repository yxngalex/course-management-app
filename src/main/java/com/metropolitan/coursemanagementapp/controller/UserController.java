package com.metropolitan.coursemanagementapp.controller;

import com.metropolitan.coursemanagementapp.entity.Role;
import com.metropolitan.coursemanagementapp.entity.User;
import com.metropolitan.coursemanagementapp.service.RoleService;
import com.metropolitan.coursemanagementapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/admin")
    public String getAllUsers(Model model) {
        model.addAttribute("getUsers", userService.getAllUsers());
        /*stranica ne postoji*/
        return "admin/user_table";
    }

    @GetMapping("/add_new_user")
    public String addNewUser(Model model) {
        User user = new User();
        List<Role> roleList =  roleService.getAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("roleList", roleList);
        return "admin/add_user";
    }

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        List<Role> roleList =  roleService.getAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("roleList", roleList);
        return "core/register";
    }

    @PostMapping("/save_user")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        /*menja se po dogovoru*/
        return "redirect:/user/user_table";
    }

    @PostMapping(value = "/delete_user/{userId}")
    public String deleteUser(@PathVariable Integer userId) {
        List<User> userList = userService.getAllUsers();
        for (User user : userList) {
            if (user.getId() == userId) {
                userService.deleteById(userId);
            }
        }
        /*menja se po dogovoru*/
        return "redirect:/index";
    }

    @GetMapping("/edit_user/{userId}")
    public String editUser(@PathVariable Integer userId, Model model) {
        List<User> userList = userService.getAllUsers();

        for (User user : userList) {
            if (user.getId() == userId) {
                model.addAttribute("user", user);
            }

        }
        return "admin/edit_user";
    }

}
