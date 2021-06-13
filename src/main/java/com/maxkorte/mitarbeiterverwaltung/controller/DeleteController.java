package com.maxkorte.mitarbeiterverwaltung.controller;

import com.maxkorte.mitarbeiterverwaltung.repository.MitarbeiterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mitarbeiterverwaltung/delete")
public class DeleteController {
    private final MitarbeiterRepository mr;

    public DeleteController(MitarbeiterRepository mr) {
        this.mr = mr;
    }

    @GetMapping("")
    public String index(@RequestParam(value = "id") String id) {
        mr.deleteById(Long.parseLong(id));
        return "/delete/get";
    }
}
