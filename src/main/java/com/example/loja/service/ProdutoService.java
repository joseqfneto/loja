package com.example.loja.service;

import java.util.List;

import com.example.loja.entity.Produto;
import com.example.loja.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElse(new Produto());
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public void save(Produto produto) {
        produtoRepository.save(produto);
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }
}
