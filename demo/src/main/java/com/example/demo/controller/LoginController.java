package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showForm(Model model) {
        model.addAttribute("user", new User()); // send object to view
        return "login-view";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {

        if(user.getUsername().equals("admin") &&
           user.getPassword().equals("1234")) {

            model.addAttribute("message", "Login Successful ✅");
        } else {
            model.addAttribute("message", "Invalid ❌");
        }

        return "login-view";
    }
}