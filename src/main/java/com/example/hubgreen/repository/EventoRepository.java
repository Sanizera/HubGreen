package com.example.hubgreen.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hubgreen.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByStEvento(Evento.StatusEvento status);
    List<Evento> findByCidade_CdCidade(Long cdCidade);
    List<Evento> findByCidade_Estado_Sguf(String sguf);
    List<Evento> findByDthrEvento(LocalDateTime agora);
}
