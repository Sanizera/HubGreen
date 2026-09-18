package com.example.hubgreen.controller.Api;

import com.example.hubgreen.repository.EventoRepository;
import com.example.hubgreen.service.EventoService;
import org.springframework.web.bind.annotation.RestController;

import com.example.hubgreen.model.Cidade;
import com.example.hubgreen.service.CidadeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("api/v1/cidades")
public class CidadeRestController {
    private final CidadeService cidadeService;

    public CidadeRestController(CidadeService cidadeService){
        this.cidadeService = cidadeService;

    }

    @GetMapping
    public List<Cidade> listarCidades() {
        return cidadeService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cidadeService.buscarPorId(id));
    }

    @GetMapping("/estado/{sguf}")
    public List<Cidade> buscarPorEstado(@PathVariable String sguf) {
        return cidadeService.buscarPorEstado(sguf);
    }
    
    
    
}
