package com.example.hubgreen.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hubgreen.model.Estado;
import com.example.hubgreen.repository.EstadoRepository;



@Service 
public class EstadoService {
    
    private final EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository){
        this.estadoRepository = estadoRepository;
    }

    @Transactional(readOnly = true)
    public List<Estado> listarTodos(){
        return estadoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Estado buscarPorSguf(String sguf){
        return estadoRepository.findById(sguf)
            .orElseThrow();
    }


}
