package com.example.loja.controller;

import com.example.loja.entity.Categoria;
import com.example.loja.repository.CategoriaRepository;
import com.example.loja.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping("/edit")
    @Secured("categoria_edit")
    public String edit(@RequestParam(value = "id", defaultValue = "0") Long id, Model model) {

        model.addAttribute("categoria", categoriaService.findById(id));
        model.addAttribute("categorias", categoriaRepository.findAll());

        return "categoria/edit";
    }
    
    @RequestMapping("/save")
    @Secured("categoria_edit")
    public String save(Categoria categoria) {
        categoriaRepository.save(categoria);
        return "redirect:/categoria/edit";
    }
}
