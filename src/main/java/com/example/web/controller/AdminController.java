package com.example.web.controller;

import com.example.web.model.User;
import com.example.web.service.RoleService;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping()
    public String index(Model model, Authentication authentication) {
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        model.addAttribute("userRoles", roleService.getAllRoles());
        return "admin";
    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute("newUser") User newUser) {
        if(Objects.nonNull(newUser) && newUser.getAge() != 0 && newUser.getName() != null && newUser.getSurname() != null) {
            userService.saveUser(newUser);
        }
        return "redirect:/admin";
    }


    @PatchMapping("/{id}")
    public String editUser(@PathVariable("id") int id, @ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

}
