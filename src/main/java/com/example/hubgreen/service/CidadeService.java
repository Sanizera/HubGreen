package com.example.hubgreen.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hubgreen.model.Cidade;
import com.example.hubgreen.repository.CidadeRepository;

@Service 
public class CidadeService {
    
    private final CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository){
        this.cidadeRepository = cidadeRepository;
    }

    @Transactional(readOnly = true)
    public List<Cidade> listarTodos(){
        return cidadeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cidade buscarPorId(Long id){
        return cidadeRepository.findById(id)
            .orElseThrow();
    }
    
    @Transactional(readOnly = true)
    public List<Cidade> buscarPorEstado(String sguf){
        return cidadeRepository.findByEstado_Sguf(sguf);
    }

    @Transactional
    public Cidade criar(Cidade cidade){
        return cidadeRepository.save(cidade);
    }

}
