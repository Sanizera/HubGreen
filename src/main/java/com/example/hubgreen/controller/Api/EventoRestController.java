package com.example.hubgreen.controller.Api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hubgreen.model.Evento;
import com.example.hubgreen.service.EventoService;



@RestController
@RequestMapping("api/v1/eventos")
public class EventoRestController {
    private final EventoService eventoService;

    public EventoRestController(EventoService eventoService){
        this.eventoService = eventoService;
    }

    @GetMapping
    public List<Evento> events() {

        List<Evento> events = eventoService.listarTodos();
        return events;

    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Evento> event(@PathVariable long id){

       return ResponseEntity.ok(eventoService.buscarPorId(id));

    }

    @PostMapping
    public ResponseEntity<Evento> postEvent(@RequestBody Evento evento) {

        Evento salvo = eventoService.criar(evento);
        return ResponseEntity.status(201).body(salvo);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> putEvent(@PathVariable Long id, @RequestBody Evento evento) {
        
        return ResponseEntity.ok(eventoService.atualizar(id, evento));
    }
}
