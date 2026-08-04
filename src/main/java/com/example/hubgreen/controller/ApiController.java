package com.example.hubgreen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/v1/")
public class ApiController {
    
    @GetMapping("events")
    public List<Object> events() {
        List<Object> events = new ArrayList<Object>();
        return events;

        // List<Event> events = eventService.listAll();
    }
    
    @GetMapping("events/{id}")
    public String event(@PathVariable long id) {
        return new String();
        //Event event = eventService.getById(id);
        // if(event) return event;
        
    }
    @PostMapping("events")
    public String postEvent(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    @PutMapping("events/{id}")
    public String putEvent(@PathVariable long id, @RequestBody String entity) {
        //TODO: process PUT request
        
        return entity;
    }
}
