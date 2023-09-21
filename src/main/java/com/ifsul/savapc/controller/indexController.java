package com.ifsul.savapc.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.management.MXBean;

@Controller
public class indexController {

    //////////////////// LOGIN////////////////////////////

    @GetMapping("/")
    public String indexController() {
        return "redirect:/index";
    }
    @GetMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }







}
