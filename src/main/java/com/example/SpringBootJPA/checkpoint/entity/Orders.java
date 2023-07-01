package com.example.SpringBootJPA.checkpoint.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "data")
    private Date data;
    @Column(name = "quantità")
    private Integer quantita;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products prodotto;

    public Orders(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public Products getProdotto() {
        return prodotto;
    }

    public void setProdotto(Products prodotto) {
        this.prodotto = prodotto;
    }
}
