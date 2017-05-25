package edu.mum.coffee.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    String index(){
        return "index";
    }

    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    // Login erro
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", "You are not authorized to access this resources");
        return "login";
    }
}
