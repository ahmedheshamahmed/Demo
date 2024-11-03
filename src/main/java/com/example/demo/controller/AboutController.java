package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About Us - Loomi's Macrame Brand");
        model.addAttribute("description", "Welcome to our macrame world! Our passion is to create unique and beautiful macrame pieces that brighten up your space.");
        return "about"; // This will map to about.html
    }

}
