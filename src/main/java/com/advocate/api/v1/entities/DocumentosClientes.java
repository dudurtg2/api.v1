package com.advocate.api.v1.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "documentosclientes")
public class DocumentosClientes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "linkRg")
    private String linkRg;

    @Column(name = "linkResidencia")
    private String linkResidencia;

    @Column(name = "linkEstadoCivil")
    private String linkEstadoCivil;

    @ElementCollection
    @CollectionTable(name = "linkProvas_table", joinColumns = @JoinColumn(name = "linkProvas_id"))
    @Column(name = "linkProvas")
    private List<String> linkProvas = new ArrayList<>();
    
    public DocumentosClientes() {
    }

    public DocumentosClientes(int id, String linkRg, String linkResidencia, String linkEstadoCivil, List<String> linkProvas) {
        this.id = id;
        this.linkRg = linkRg;
        this.linkResidencia = linkResidencia;
        this.linkEstadoCivil = linkEstadoCivil;
        this.linkProvas = linkProvas;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinkRg() {
        return this.linkRg;
    }

    public void setLinkRg(String linkRg) {
        this.linkRg = linkRg;
    }

    public String getLinkResidencia() {
        return this.linkResidencia;
    }

    public void setLinkResidencia(String linkResidencia) {
        this.linkResidencia = linkResidencia;
    }

    public String getLinkEstadoCivil() {
        return this.linkEstadoCivil;
    }

    public void setLinkEstadoCivil(String linkEstadoCivil) {
        this.linkEstadoCivil = linkEstadoCivil;
    }

    public List<String> getLinkProvas() {
        return linkProvas;
    }

    public void setLinkProvas(List<String> linkProvas) {
        this.linkProvas = linkProvas;
    }

    
}
