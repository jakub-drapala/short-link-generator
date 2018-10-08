package com.drapala.shortlinkgenerator.controller;

import com.drapala.shortlinkgenerator.sercive.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GeneratorController {

    private final GeneratorService service;

    @Autowired
    public GeneratorController(GeneratorService service) {
        this.service = service;
    }

    @GetMapping("/short-link-generator")
    public String hello() {
        return "generator";
    }

    @PostMapping("generate")
    public String linkGenerate(@RequestParam String longLink) {

        service.saveLink(longLink);

        return "redirect:/short-link-generator";
    }

}
