package com.drapala.shortlinkgenerator.controller;

import com.drapala.shortlinkgenerator.sercive.GeneratorService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;

@Slf4j
@Controller
public class GeneratorController {

    private final GeneratorService service;

    private String lastLink;


    @Autowired
    public GeneratorController(GeneratorService service) {
        this.service = service;
    }

    @GetMapping("/short-link-generator")
    public String hello(Model model) {
        model.addAttribute("shortLink", lastLink);
        return "generator";
    }

    @PostMapping("generate")
    public String linkGenerate(@RequestParam String longLink) {

        this.lastLink = this.service.process(longLink);

        return "redirect:/short-link-generator";
    }


    @RequestMapping(value = "/{shortLink}",method = RequestMethod.GET)
    public String redirectToApriopriatePage(@PathVariable String shortLink) {

        log.info("Url to redirect: {}", shortLink);
        String longLink = service.getLongLink(shortLink);



        return "redirect:/" + longLink;

    }






}
