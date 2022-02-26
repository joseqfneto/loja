package com.example.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loja.entity.Categoria;
import com.example.loja.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria findById(Long id) {
		return categoriaRepository.findById(id).orElse(new Categoria());
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
}
