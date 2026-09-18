package com.example.hubgreen.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name = "eventos")
public class Evento {
    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CDEVENTO")
    private Long cdEvento;

    @Column(name = "NMEVENTO", nullable = false, length = 100)
    private String nmEvento;

    @Column(name = "LOCALEVENTO", nullable = false, length = 200)
    private String localEvento;

    @Column(name = "DTHREVENTO", nullable=false)
    private LocalDateTime dthrEvento;

    @ManyToOne
    @JoinColumn(name = "CDCIDADE", nullable = false)
    private Cidade cidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "STEVENTO", nullable = false)
    private StatusEvento stEvento = StatusEvento.MARCADO;

    @Column(name= "DSEVENTO", columnDefinition="TEXT")
    private String dsEvento;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<EvImagem> imagens = new ArrayList<>();

    public Long getCdEvento() {
        return cdEvento;
    }

    public void setCdEvento(Long cdEvento) {
        this.cdEvento = cdEvento;
    }

    public String getNmEvento() {
        return nmEvento;
    }

    public void setNmEvento(String nmEvento) {
        this.nmEvento = nmEvento;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public StatusEvento getStEvento() {
        return stEvento;
    }

    public void setStEvento(StatusEvento stEvento) {
        this.stEvento = stEvento;
    }

    public String getDsEvento() {
        return dsEvento;
    }

    public void setDsEvento(String dsEvento) {
        this.dsEvento = dsEvento;
    }

    public List<EvImagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<EvImagem> imagens) {
        this.imagens = imagens;
    }

    public LocalDateTime getDthrEvento(){
        return this.dthrEvento;
    }

    public void setDthrEvento(LocalDateTime dthrEvento){
        this.dthrEvento = dthrEvento;
    }
    
    public enum StatusEvento{
        MARCADO, EM_ANDAMENTO, FINALIZADO, CANCELADO
    }



    public Evento(){}

    
}
