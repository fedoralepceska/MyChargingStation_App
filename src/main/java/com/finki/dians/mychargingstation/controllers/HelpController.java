package com.finki.dians.mychargingstation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faq")
public class HelpController {

    @GetMapping
    public String getAboutUsPage(Model model) {
        model.addAttribute("bodyContent", "faq");

        return "master-template";
    }

}