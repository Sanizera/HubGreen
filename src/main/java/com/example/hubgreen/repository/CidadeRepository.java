package com.example.hubgreen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hubgreen.model.Cidade;

@Repository 
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    List<Cidade> findByEstado_Sguf(String sguf);
    List<Cidade> findByNmCidadeContainingIgnoreCase(String nome);
}
