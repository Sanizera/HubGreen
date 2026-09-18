package com.example.hubgreen.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name = "expositores")
public class Expositor {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CDEXPOSITOR")
    private Long cdExpositor;

    @Column(name = "NMEXPOSITOR", length = 100)
    private String nmExpositor;

    @Column(name = "BIOEXPOSITOR", columnDefinition = "TEXT")
    private String bioExpositor;

    @OneToMany(mappedBy="expositor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produto> produtos = new ArrayList<>();

    @OneToMany(mappedBy="expositor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExpImagem> imagens = new ArrayList<>();

    public Expositor (){}

    public Long getCdExpositor() {
        return cdExpositor;
    }

    public void setCdExpositor(Long cdExpositor) {
        this.cdExpositor = cdExpositor;
    }

    public String getNmExpositor() {
        return nmExpositor;
    }

    public void setNmExpositor(String nmExpositor) {
        this.nmExpositor = nmExpositor;
    }

    public String getBioExpositor() {
        return bioExpositor;
    }

    public void setBioExpositor(String bioExpositor) {
        this.bioExpositor = bioExpositor;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<ExpImagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<ExpImagem> imagens) {
        this.imagens = imagens;
    }


}
