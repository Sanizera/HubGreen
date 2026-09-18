package com.example.hubgreen.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hubgreen.model.Categoria;

@Repository 
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNmCategoria(String nmCategoria);
}
