package com.example.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.loja.entity.Perfil;
import com.example.loja.repository.PerfilRepository;
import com.example.loja.repository.PermissaoRepository;
import com.example.loja.service.PerfilService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private PerfilRepository perfilRepository;

	@Autowired
	private PermissaoRepository permissaoRepository;

	@RequestMapping("/edit")
	@Secured("perfil_edit")
	public String home(@RequestParam(value = "id", defaultValue = "0") Long id, Model model) {
		model.addAttribute("perfil", perfilService.findById(id));
		model.addAttribute("permissoes", permissaoRepository.findAll());
		model.addAttribute("perfis", perfilRepository.findAll());
		return "perfil/edit";
	}

	@Secured("perfil_edit")
	@RequestMapping("/save")
	public String save(Perfil perfil) {
		perfilRepository.save(perfil);
		return "redirect:/perfil/edit";
	}

	@Secured("perfil_delete")
	@RequestMapping("/remove")
	public String remove(Perfil perfil){
		perfilRepository.deleteById(perfil.getId());
		return "redirect:/perfil/edit";
	}
}
