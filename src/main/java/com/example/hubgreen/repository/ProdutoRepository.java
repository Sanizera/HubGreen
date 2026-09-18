package com.example.hubgreen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hubgreen.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByExpositor_CdExpositor(Long cdExpositor);
    List<Produto> findByCategoria_CdCategoria(Long cdCategoria);
    List<Produto> findByNmProdutoContainingIgnoreCase(String nome);

}
