package com.example.hubgreen.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hubgreen.model.Participacao;

@Repository 
public interface ParticipacaoRepository extends JpaRepository<Participacao, Long>{
    List<Participacao> findByEvento_CdEvento(Long cdEvento);
    List<Participacao> findByExpositor_CdExpositor(Long cdExpositor);
    Optional<Participacao> findByEvento_CdEventoAndExpositor_CdExpositor(Long cdEvento, Long cdExpositor);
    List<Participacao> findByStParticipacao(Participacao.StatusParticipacao status);
}
