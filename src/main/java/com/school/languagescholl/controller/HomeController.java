package com.school.languagescholl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    public HomeController() {
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/logout")
    public String logout() {
        return "/logout";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

}

