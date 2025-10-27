package com.senai.CRUD.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewHomeController {
    @GetMapping("/home")
    public String viewHome(Model model){
        return "home";
    }
}
