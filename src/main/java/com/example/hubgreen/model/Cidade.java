package com.example.hubgreen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "cidades") 
public class Cidade {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "CDCIDADE")
    private Long cdCidade;

    @Column(name  = "NMCIDADE", nullable=false, length=50)
    private String nmCidade;

    @ManyToOne 
    @JoinColumn(name = "SGUF", nullable = false)
    private Estado estado;

    public Cidade(){}

    public Long getCdCidade() {
        return cdCidade;
    }

    public void setCdCidade(Long cdCidade) {
        this.cdCidade = cdCidade;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


}
