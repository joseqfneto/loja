package com.example.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
public class ConfigController {

    @RequestMapping("/acessoNegado")
    public String acessoNegado(Model model) {
        model.addAttribute("title", "Acesso Negado");
        model.addAttribute("msg", "Você não tem permissão para acessar este recurso!");
        return "custom";
    }
}
