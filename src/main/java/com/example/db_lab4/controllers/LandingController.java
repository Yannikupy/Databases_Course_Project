package com.example.db_lab4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {

    @GetMapping("/database")
    public String database(Model model) {
        return "landing";
    }

}
