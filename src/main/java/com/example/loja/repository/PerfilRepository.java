package com.example.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loja.entity.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
