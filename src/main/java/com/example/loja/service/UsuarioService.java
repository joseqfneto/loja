package com.example.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.loja.entity.Usuario;
import com.example.loja.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElse(new Usuario());
	}

	/* Metodo para gravar o password no banco codificado */
	public void save(Usuario usuario) {
		if (!usuarioRepository.existsByUsername(usuario.getUsername())) {
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			usuarioRepository.save(usuario);
		} else {
			throw new IllegalArgumentException("Um usuário com este nome já existe!");
		}
	}
}