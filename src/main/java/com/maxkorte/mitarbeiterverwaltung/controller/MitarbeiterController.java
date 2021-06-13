package com.maxkorte.mitarbeiterverwaltung.controller;

import com.maxkorte.mitarbeiterverwaltung.repository.MitarbeiterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mitarbeiterverwaltung/mitarbeiter")
public class MitarbeiterController {
    private final MitarbeiterRepository mr;

    public MitarbeiterController(MitarbeiterRepository mr) {
        this.mr = mr;
    }

    @GetMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("mitarbeiter", mr.findAll());
        return "/mitarbeiter/get";
    }
}
