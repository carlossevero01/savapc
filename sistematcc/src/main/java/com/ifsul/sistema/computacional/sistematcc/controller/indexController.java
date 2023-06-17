package com.ifsul.sistema.computacional.sistematcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {

    //////////////////// LOGIN////////////////////////////

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/index/inicial";
    }

    /* PAGINA INICIAL(TODOS) */
    @GetMapping(value = "/index/inicial")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    /* PAGINA INICIAL(TODOS) */

}
