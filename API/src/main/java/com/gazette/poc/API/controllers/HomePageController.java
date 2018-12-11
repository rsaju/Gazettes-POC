package com.gazette.poc.API.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @Value("${home.page.heading}")
    private String heading;

    @GetMapping("/")
    public String showHomePage(Model model){

        model.addAttribute("heading",heading);
        return "homepage";
    }
}
