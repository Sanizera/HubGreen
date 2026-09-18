package com.example.hubgreen.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDPRODUTO")
    private Long cdProduto;

    @Column(name = "NMPRODUTO", nullable = false, length = 50)
    private String nmProduto;

    @Column(name = "DSPRODUTO", columnDefinition="TEXT")
    private String dsProduto;

    @ManyToOne
    @JoinColumn(name = "CDEXPOSITOR", nullable = false)
    private Expositor expositor;

    @Column(name = "CAMINHOIMAGEM", length = 500)
    private String caminhoImagem;

    @Column(name = "VALOR", precision= 12, scale = 2)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "CDCATEGORIA", nullable = false)
    private Categoria categoria;

    public Produto(){}

    public Long getCdProduto() {
        return cdProduto;
    }

    public void setCdProduto(Long cdProduto) {
        this.cdProduto = cdProduto;
    }

    public String getNmProduto() {
        return nmProduto;
    }

    public void setNmProduto(String nmProduto) {
        this.nmProduto = nmProduto;
    }

    public String getDsProduto() {
        return dsProduto;
    }

    public void setDsProduto(String dsProduto) {
        this.dsProduto = dsProduto;
    }

    public Expositor getExpositor() {
        return expositor;
    }

    public void setExpositor(Expositor expositor) {
        this.expositor = expositor;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


}
