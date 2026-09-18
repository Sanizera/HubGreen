package com.example.hubgreen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDCATEGORIA")
    private Long cdCategoria;

    @Column(name = "NMCATEGORIA", nullable = false, length= 60, unique = true)
    private String nmCategoria;

    @Column(name = "DSCATEGORIA", length = 200)
    private String dsCategoria;

    public Categoria(){}

    public Long getCdCategoria() {
        return cdCategoria;
    }

    public void setCdCategoria(Long cdCategoria) {
        this.cdCategoria = cdCategoria;
    }

    public String getNmCategoria() {
        return nmCategoria;
    }

    public void setNmCategoria(String nmCategoria) {
        this.nmCategoria = nmCategoria;
    }

    public String getDsCategoria() {
        return dsCategoria;
    }

    public void setDsCategoria(String dsCategoria) {
        this.dsCategoria = dsCategoria;
    }

}
