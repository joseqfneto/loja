package com.example.loja.controller;

import com.example.loja.entity.Produto;
import com.example.loja.service.CategoriaService;
import com.example.loja.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping("/edit")
	@Secured("produto_edit")
	public String edit(@RequestParam(name = "id", defaultValue = "0") Long id, Model model) {
		Produto produto = produtoService.findById(id);
		model.addAttribute("produto", produto);
		model.addAttribute("produtos", produtoService.findAll());
		model.addAttribute("categorias", categoriaService.findAll());
		return "/produto/edit";
	}

	@RequestMapping("/save")
	public String save(Produto produto) {
		produtoService.save(produto);
		return "redirect:/produto/edit";
	}

	@RequestMapping("/remove")
	public String remove(@RequestParam(name = "id") Long id) {
		produtoService.deleteById(id);
		return "redirect:/produto/edit";
	}
}
