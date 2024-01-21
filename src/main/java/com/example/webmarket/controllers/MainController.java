package com.example.webmarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("home","Главная страница");
        return "home";
    }
    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("home","Страница про нас");
        return "about";
    }
}
