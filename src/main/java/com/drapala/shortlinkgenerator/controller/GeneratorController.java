package com.drapala.shortlinkgenerator.controller;

import com.drapala.shortlinkgenerator.sercive.GeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class GeneratorController {

    private final GeneratorService service;

    private String lastShortLink;
    private String lastLongLink;


    @Autowired
    public GeneratorController(GeneratorService service) {
        this.service = service;
    }

    @GetMapping("/short-link-generator")
    public String hello(Model model) {
        model.addAttribute("shortLink", lastShortLink);
        model.addAttribute("longLink", lastLongLink);
        return "generator";
    }

    @PostMapping("generate")
    public String linkGenerate(@RequestParam String longLink) {

        this.lastLongLink = longLink;

        this.lastShortLink = this.service.process(longLink);

        return "redirect:/short-link-generator";
    }


    @RequestMapping(value = "/{shortLink}",method = RequestMethod.GET)
    public String redirectToApriopriatePage(@PathVariable String shortLink) {

        log.info("Url to redirect: {}", shortLink);
        String longLink = service.getLongLink(shortLink);



        return "redirect:/" + longLink;

    }






}
