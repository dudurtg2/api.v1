package com.advocate.api.v1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nascionalidade")
    private String nascionalidade;

    @Column(name = "estado_civil")
    private String estadoCivil;

    @Column(name = "proficao")
    private String proficao;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "data_nascimento")
    private String dataNascimento;

    @Column(name = "telefoneFixo")
    private String telefoneFixo;

    @Column(name = "telefoneCelular")
    private String telefoneCelular;

    @Column(name = "email")
    private String email;
    

    public Clientes() {
    }

    public Clientes(int id, String nome, String cpf, String nascionalidade, String estadoCivil, String proficao, String endereco, String dataNascimento, String telefoneFixo, String telefoneCelular, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.nascionalidade = nascionalidade;
        this.estadoCivil = estadoCivil;
        this.proficao = proficao;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.email = email;
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

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascionalidade() {
        return this.nascionalidade;
    }

    public void setNascionalidade(String nascionalidade) {
        this.nascionalidade = nascionalidade;
    }

    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProficao() {
        return this.proficao;
    }

    public void setProficao(String proficao) {
        this.proficao = proficao;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefoneFixo() {
        return this.telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneCelular() {
        return this.telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}