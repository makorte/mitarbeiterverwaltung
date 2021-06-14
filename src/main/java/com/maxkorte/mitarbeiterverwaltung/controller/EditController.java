package com.maxkorte.mitarbeiterverwaltung.controller;

import com.maxkorte.mitarbeiterverwaltung.entity.Mitarbeiter;
import com.maxkorte.mitarbeiterverwaltung.repository.MitarbeiterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mitarbeiterverwaltung/edit")
public class EditController {
    private final MitarbeiterRepository mr;

    public EditController(MitarbeiterRepository mr) {
        this.mr = mr;
    }

    @GetMapping("")
    public String get(@RequestParam(value = "id") String id, Model model) {
        model.addAttribute("mitarbeiter", mr.findById(Long.parseLong(id)).get());
        return "/edit/get";
    }

    @PostMapping("/post")
    public String post(@RequestParam(value = "id") String id,
                       @RequestParam(value = "vorname") String vorname,
                       @RequestParam(value = "nachname") String nachname,
                       @RequestParam(value = "email", required = false) String email,
                       @RequestParam(value = "telefon", required = false) String telefon) {
        mr.deleteById(Long.parseLong(id));
        mr.save(new Mitarbeiter(vorname, nachname, email, telefon));

        return "/edit/post";
    }
}
