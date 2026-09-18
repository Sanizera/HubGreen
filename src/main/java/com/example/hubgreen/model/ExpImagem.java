package com.example.hubgreen.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "expimagens")
public class ExpImagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDEXPIMAGEM")
    private Long cdExpImagem;

    @ManyToOne
    @JoinColumn(name = "CDEXPOSITOR", nullable = false)
    private Expositor expositor;

    @Column(name = "CAMINHOEXPIMAGEM", nullable = false, length = 500)
    private String caminhoExpImagem;

    @Column(name = "DTEXPIMAGEM", nullable = false)
    private LocalDateTime dtExpImagem;

    @Enumerated(EnumType.STRING)
    @Column(name = "IDEXPIMAGEM", nullable = false)
    private TipoImagem idExpImagem = TipoImagem.outras;

    public Long getCdExpImagem() {
        return cdExpImagem;
    }

    public void setCdExpImagem(Long cdExpImagem) {
        this.cdExpImagem = cdExpImagem;
    }

    public Expositor getExpositor() {
        return expositor;
    }

    public void setExpositor(Expositor expositor) {
        this.expositor = expositor;
    }

    public String getCaminhoExpImagem() {
        return caminhoExpImagem;
    }

    public void setCaminhoExpImagem(String caminhoExpImagem) {
        this.caminhoExpImagem = caminhoExpImagem;
    }

    public LocalDateTime getDtExpImagem() {
        return dtExpImagem;
    }

    public void setDtExpImagem(LocalDateTime dtExpImagem) {
        this.dtExpImagem = dtExpImagem;
    }

    public TipoImagem getIdExpImagem() {
        return idExpImagem;
    }

    public void setIdExpImagem(TipoImagem idExpImagem) {
        this.idExpImagem = idExpImagem;
    }

    public enum TipoImagem {
        perfil, outras
    }
    
    public ExpImagem(){}

    
}
