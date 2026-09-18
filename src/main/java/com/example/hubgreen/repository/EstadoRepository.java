package com.example.hubgreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hubgreen.model.Estado;

@Repository 
public interface EstadoRepository extends JpaRepository<Estado, String>{}
