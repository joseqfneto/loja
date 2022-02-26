package com.example.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loja.entity.Permissao;
import com.example.loja.repository.PermissaoRepository;

@Service
public class PermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;

	public Permissao findById(Long id) {
		return permissaoRepository.findById(id).orElse(new Permissao());
	}
}
