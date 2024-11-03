package com.advocate.api.v1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "documentosprocessos")
public class DocumentoProcessos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "status")
    private String status;

    @Column(name = "descricao")
    private String descrisao;

    @ManyToOne
    @JoinColumn(name = "DocumentosClientes_id")
    private DocumentosClientes documentosClientes;

    public DocumentoProcessos() {

    }
    
    public DocumentoProcessos(int id, String tipo, String status, String descrisao, DocumentosClientes documentosClientes) {
        this.id = id;
        this.tipo = tipo;
        this.status = status;
        this.descrisao = descrisao;
        this.documentosClientes = documentosClientes;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescrisao() {
        return this.descrisao;
    }

    public void setDescrisao(String descrisao) {
        this.descrisao = descrisao;
    }

    public DocumentosClientes getDocumentosClientes() {
        return documentosClientes;
    }

    public void setDocumentosClientes(DocumentosClientes documentosClientes) {
        this.documentosClientes = documentosClientes;
    }


}
