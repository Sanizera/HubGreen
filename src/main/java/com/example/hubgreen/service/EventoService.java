package com.example.hubgreen.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hubgreen.model.Evento;
import com.example.hubgreen.repository.EventoRepository;

@Service 
public class EventoService {
    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository){
        this.eventoRepository = eventoRepository;
    }
    
    @Transactional(readOnly = true)
    public List<Evento> listarTodos() {
        return eventoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Evento buscarPorId(Long id){
        return eventoRepository.findById(id)
            .orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<Evento> buscarPorEstado(String sguf){
        return eventoRepository.findByCidade_Estado_Sguf(sguf);
    }

    @Transactional(readOnly = true)
    public List<Evento> buscarPorCidade(Long cdCidade){
        return eventoRepository.findByCidade_CdCidade(cdCidade);
    }

    @Transactional
    public Evento criar(Evento evento){
        evento.setStEvento(Evento.StatusEvento.MARCADO);
        return eventoRepository.save(evento);
    }

    @Transactional
    public Evento atualizar(Long id, Evento dadosAtualizados){
        Evento evento = buscarPorId(id);

        evento.setNmEvento(dadosAtualizados.getNmEvento());
        evento.setLocalEvento(dadosAtualizados.getLocalEvento());
        evento.setDsEvento(dadosAtualizados.getDsEvento());
        evento.setDthrEvento(dadosAtualizados.getDthrEvento());

        return eventoRepository.save(evento);

    }

    @Transactional
    public void cancelar(Long id){
        Evento evento = buscarPorId(id);
        evento.setStEvento(Evento.StatusEvento.CANCELADO);
        eventoRepository.save(evento);
    }
        
}
