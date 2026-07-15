package com.example.hubgreen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class PageController {
    @GetMapping("/search")
    public String search() {
        return "search";
    }
    
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/event")
    public String event() {
        return "event";
    }
    
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/lista_usuario")
    public String listaUsuario() {
        return "lista_usuario";
    }
    
}
