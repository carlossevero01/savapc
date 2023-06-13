package com.ifsul.sistema.computacional.sistematcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.usuarioRepository;

@Controller
public class indexController {
    @Autowired
    usuarioRepository usuarioRepository;
    @Autowired
    turmaRepository turmaRepository;
    
    

    ////////////////////LOGIN////////////////////////////
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }   
    @GetMapping("/")
    public String home(){
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
