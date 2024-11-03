package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Contact Us - Loomi's Macrame Brand");
        return "contact"; // This will map to contact.html
    }

    @PostMapping("/contact")
    public String handleContact(@RequestParam String name, @RequestParam String email, @RequestParam String message, Model model) {
        // Here you can implement the logic to handle the contact form submission (e.g., send an email)
        model.addAttribute("title", "Thank You for Your Message!");
        model.addAttribute("message", "Thank you, " + name + "! We'll get back to you shortly.");
        return "thankyou"; // Redirect to a thank you page
    }

}
