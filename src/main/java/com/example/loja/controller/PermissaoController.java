package com.example.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.loja.entity.Permissao;
import com.example.loja.repository.PermissaoRepository;
import com.example.loja.service.PermissaoService;

@Controller
@RequestMapping("/permissao")
public class PermissaoController {

	@Autowired
	private PermissaoRepository permissaoRepository;

	@Autowired
	private PermissaoService permissaoService;

	@RequestMapping("/edit")
	@Secured("permissao_edit")
	public String edit(@RequestParam(value = "id", defaultValue = "0") Long id, Model model) {
		model.addAttribute("permissao", permissaoService.findById(id));
		model.addAttribute("permissoes", permissaoRepository.findAll());
		return "/permissao/edit";
	}

	@RequestMapping("/save")
	@Secured("permissao_edit")
	public String save(Permissao permissao) {
		permissaoRepository.save(permissao);
		return "redirect:/permissao/edit";
	}

	@RequestMapping("/remove")
	@Secured("permissao_delete")
	public String remove(Permissao permissao) {
		permissaoRepository.deleteById(permissao.getId());
		return "redirect:/permissao/edit";
	}

}
