package com.maxkorte.mitarbeiterverwaltung.controller;

import com.maxkorte.mitarbeiterverwaltung.entity.Mitarbeiter;
import com.maxkorte.mitarbeiterverwaltung.repository.MitarbeiterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mitarbeiterverwaltung")
public class IndexController {
    private final MitarbeiterRepository mr;

    public IndexController(MitarbeiterRepository mr) {
        this.mr = mr;
    }

    @GetMapping({"", "/", "/get", "/get/"})
    public String index() {
        return "/index/get";
    }

    @PostMapping({"/add", "/add/"})
    public String addMitarbeiter(@RequestParam(value = "vorname") String vorname,
                                 @RequestParam(value = "nachname") String nachname,
                                 @RequestParam(value = "email", required = false) String email,
                                 @RequestParam(value = "telefon", required = false) String telefon) {
        mr.save(new Mitarbeiter(vorname, nachname, email, telefon));
        return "/index/post";
    }
}
