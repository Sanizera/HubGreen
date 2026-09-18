package com.example.hubgreen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hubgreen.model.Expositor;
@Repository 
public interface ExpositorRepository extends JpaRepository<Expositor, Long> {
    List<Expositor> findByNmExpositorContainingIgnoreCase(String nome);
}
