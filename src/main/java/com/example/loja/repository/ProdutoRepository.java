package com.example.loja.repository;

import java.util.Optional;

import com.example.loja.entity.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	// List<Produto> findByNome(String nome);

	Optional<Produto> findById(Long id);

}
