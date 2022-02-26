package com.example.loja.controller;

import com.example.loja.entity.Usuario;
import com.example.loja.repository.PerfilRepository;
import com.example.loja.repository.UsuarioRepository;
import com.example.loja.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/edit")
    public String edit(@RequestParam(value = "id", defaultValue = "0") Long id, Model model) {
        Usuario usuario = usuarioService.findById(id);
        //usuario.setPassword("");// apenas para não mostrar o cript
        model.addAttribute("usuario", usuario);
        model.addAttribute("perfis", perfilRepository.findAll());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "/usuario/edit";
    }

    @RequestMapping("/save")
    public String save(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuario/edit";
    }

    @RequestMapping("/remove")
    public String remove(Usuario usuario) {
        usuarioRepository.deleteById(usuario.getId());
        return "redirect:/usuario/edit";
    }
}
