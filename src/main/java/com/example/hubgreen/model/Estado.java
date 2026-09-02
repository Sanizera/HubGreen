package com.example.hubgreen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "estados")
public class Estado {
    @Id 
    @Column(name = "SGUF", length = 2)
    private String sguf;

    @Column(name = "NMUF", nullable=false, length=20)
    private String nmuf;

    
}
