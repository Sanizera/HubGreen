package com.example.hubgreen.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hubgreen.model.ExpImagem;

@Repository 
public interface ExpImagemRepository extends JpaRepository<ExpImagem, Long> {
    List<ExpImagem> findByExpositor_CdExpositor(Long cdExpositor);
    Optional<ExpImagem> findByExpositor_CdExpositorAndIdExpImagem(Long cdExpositor, ExpImagem.TipoImagem tipo);    
}
