package com.example.hubgreen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hubgreen.model.EvImagem;

@Repository 
public interface EvImagemRepository extends JpaRepository<EvImagem, Long> {
    List<EvImagem> findByEvento_CdEvento(Long cdEvento);
}
