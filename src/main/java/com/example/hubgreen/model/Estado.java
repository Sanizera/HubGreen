package com.example.hubgreen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "estados")
public class Estado {
    @Id 
    @Column(name = "SGUF", columnDefinition="CHAR(2)")
    private String sguf;

    @Column(name = "NMUF", nullable=false, length=30)
    private String nmuf;

    public Estado(){}
    
    public String getSguf() {
        return sguf;
    }

    public String getNmuf() {
        return nmuf;
    }

    public void setSguf(String sguf) {
        this.sguf = sguf;
    }

    public void setNmuf(String nmuf) {
        this.nmuf = nmuf;
    }

    
}
