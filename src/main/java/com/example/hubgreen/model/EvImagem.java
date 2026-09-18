package com.example.hubgreen.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity 
@Table(name = "evimagens")
public class EvImagem{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDEVIMAGEM")
    private Long cdEvImagem;

    @ManyToOne 
    @JoinColumn(name = "CDEVENTO", nullable = false)
    private Evento evento;

    @Column(name = "CAMINHOEVIMAGEM", nullable = false, length = 500)
    private String caminhoEvImagem;

    @Column(name = "DTEVIMAGEM")
    private LocalDateTime dtEvImagem;

    public EvImagem (){};

    public Long getCdEvImagem() {
        return cdEvImagem;
    }

    public void setCdEvImagem(Long cdEvImagem) {
        this.cdEvImagem = cdEvImagem;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getCaminhoEvImagem() {
        return caminhoEvImagem;
    }

    public void setCaminhoEvImagem(String caminhoEvImagem) {
        this.caminhoEvImagem = caminhoEvImagem;
    }

    public LocalDateTime getDtEvImagem() {
        return dtEvImagem;
    }

    public void setDtEvImagem(LocalDateTime dtEvImagem) {
        this.dtEvImagem = dtEvImagem;
    }


}