package com.arthur.blog.controller;

import com.arthur.blog.dto.UserDTO;
import com.arthur.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("newUser", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("newUser") UserDTO newUser) {
        userService.register(newUser);
        return "register";
    }
}
