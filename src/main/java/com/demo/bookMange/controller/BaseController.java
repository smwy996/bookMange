package com.demo.bookMange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
    @GetMapping("/")
    public String redirectToBooks() {
        return "redirect:/books/";
    }
}