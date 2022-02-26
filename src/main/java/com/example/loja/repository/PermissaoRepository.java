package com.example.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loja.entity.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
