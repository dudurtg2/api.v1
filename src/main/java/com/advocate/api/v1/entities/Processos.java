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
@Table(name = "processos")
public class Processos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "data")
    private String data;

    @Column(name = "hora")
    private String hora;

    @ManyToOne
    @JoinColumn(name = "funcionarios_id")
    private Funcionarios funcionarios;

    @ManyToOne
    @JoinColumn(name = "clientes_id")
    private Clientes clientes;

    @ManyToOne
    @JoinColumn(name = "documentoProcessos_id")
    private DocumentoProcessos documentoProcessos;

    public Processos() {
    }

    public Processos(int id, String data, String hora, Funcionarios funcionarios, Clientes clientes, DocumentoProcessos documentoProcessos, String codigo) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.funcionarios = funcionarios;
        this.clientes = clientes;
        this.documentoProcessos = documentoProcessos;
        this.codigo = codigo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Funcionarios getFuncionarios() {
        return this.funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Clientes getClientes() {
        return this.clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public DocumentoProcessos getDocumentoProcessos() {
        return documentoProcessos;
    }

    public void setDocumentoProcessos(DocumentoProcessos documentoProcessos) {
        this.documentoProcessos = documentoProcessos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    

}
