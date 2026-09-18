package com.example.hubgreen.model;

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
import jakarta.persistence.UniqueConstraint;

@Entity 
@Table(name = "participacoes", uniqueConstraints = @UniqueConstraint(columnNames= {"CDEVENTO", "CDEXPOSITOR"}))
public class Participacao {
    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CDPARTICIPACAO")
    private Long cdParticipacao;

    @ManyToOne
    @JoinColumn(name = "CDEVENTO", nullable = false)
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "CDEXPOSITOR", nullable = false)
    private Expositor expositor;

    @Enumerated(EnumType.STRING)
    @Column(name = "STPARTICIPACAO", nullable = false)
    private StatusParticipacao stParticipacao = StatusParticipacao.ATIVO;

    public Long getCdParticipacao() {
        return cdParticipacao;
    }

    public void setCdParticipacao(Long cdParticipacao) {
        this.cdParticipacao = cdParticipacao;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Expositor getExpositor() {
        return expositor;
    }

    public void setExpositor(Expositor expositor) {
        this.expositor = expositor;
    }

    public StatusParticipacao getStParticipacao() {
        return stParticipacao;
    }

    public void setStParticipacao(StatusParticipacao stParticipacao) {
        this.stParticipacao = stParticipacao;
    }

    public enum StatusParticipacao{        
        ATIVO, CANCELADO
    }

    public Participacao(){}

    
}
