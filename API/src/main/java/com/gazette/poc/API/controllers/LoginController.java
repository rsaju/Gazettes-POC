package com.gazette.poc.API.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/sign-in")
    public String getSignInPage(){
        return "signin";
    }
}
