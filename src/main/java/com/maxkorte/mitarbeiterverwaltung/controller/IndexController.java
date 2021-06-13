package com.maxkorte.mitarbeiterverwaltung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mitarbeiterverwaltung")
public class IndexController {
    @GetMapping({"", "/", "/get", "/get/"})
    public String index() {
        return "/index/get";
    }

    @PostMapping({"/add", "/add/"})
    public String addMitarbeiter() {
        return "/index/post";
    }
}
