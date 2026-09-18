package com.example.hubgreen.controller.Api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hubgreen.model.Estado;
import com.example.hubgreen.service.EstadoService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController 
@RequestMapping("api/v1/estados")
public class EstadoRestController {
    private final EstadoService estadoService;

    public EstadoRestController(EstadoService estadoService){
        this.estadoService = estadoService;
    }

    @GetMapping
    public List<Estado> listarTodos() {
        return estadoService.listarTodos();
        
    }
    
    @GetMapping("/{sguf}")
    public ResponseEntity<Estado> getMethodName(@PathVariable String sguf) {
        return ResponseEntity.ok(estadoService.buscarPorSguf(sguf));
    }
    
    
}
