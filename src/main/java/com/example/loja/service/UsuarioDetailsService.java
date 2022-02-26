package com.example.loja.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.loja.entity.Permissao;
import com.example.loja.entity.Usuario;
import com.example.loja.repository.UsuarioRepository;

@Service
@EnableGlobalMethodSecurity(securedEnabled = true)
public class UsuarioDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Bean
	GrantedAuthorityDefaults grantedAuthorityDefaults() {
		return new GrantedAuthorityDefaults(""); // remover o prefixo ROLE_
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário " + username + " não encontrado.");
		}

		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

		for (Permissao permissao : usuario.getPerfil().getPermissoes()) {
			roles.add(new SimpleGrantedAuthority(permissao.getNome()));
		}

		roles.add(new SimpleGrantedAuthority("Admin"));
		return (UserDetails) new User(usuario.getUsername(), usuario.getPassword(), roles);
	}

}
