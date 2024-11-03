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
@Table(name = "calendario")
public class Calendario {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data")
    private String data;

    @Column(name = "descrisao")
    private String descrisao;

    @Column(name = "alerta")
    private String alerta;

    @ManyToOne
    @JoinColumn(name = "funcionarios_id")
    private Funcionarios funcionarios;


    public Calendario() {
    }

    public Calendario(int id, String nome, String data, String descrisao, String alerta, Funcionarios funcionarios) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.descrisao = descrisao;
        this.alerta = alerta;
        this.funcionarios = funcionarios;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescrisao() {
        return this.descrisao;
    }

    public void setDescrisao(String descrisao) {
        this.descrisao = descrisao;
    }

    public String getAlerta() {
        return this.alerta;
    }

    public void setAlerta(String alerta) {
        this.alerta = alerta;
    }

    public Funcionarios getFuncionarios() {
        return this.funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }
    
}
