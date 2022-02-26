package com.example.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loja.entity.Perfil;
import com.example.loja.repository.PerfilRepository;
import com.example.loja.repository.PermissaoRepository;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;

	public Perfil findById(Long id) {
		return perfilRepository.findById(id).orElse(new Perfil());
	}
}
