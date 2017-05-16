package edu.mum.cs545.springboot.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@RequestMapping("/stadium")
public class StadiumController {

    @RequestMapping("/list")
    String getAll(Model model){
        return "stadiumList";
    }

}
