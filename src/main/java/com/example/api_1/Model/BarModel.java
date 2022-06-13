package com.example.api_1.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity(name = "bar")
public class BarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    public Integer id_bar;

    @NotNull
    @Column(name = "nome")
    private String nome;
    @Column (name = "telefone")
    private String telefone;

    @Column(length = 200,
            name = "descricao"
    )
    private String descricao;

    @Column(length = 8,
            name = "cep"
    )
    private String cep;

    @Column (name = "cnpj")
    private String cnpj;

    @Column (name = "avaliacao")
    private double avaliacao;

    @Column (name = "email")
    private String email;

    @Column (name = "senha")
    private String senha;

    @Column(name = "id_pessoa")
    private int id_pessoa;

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId_bar() {
        return id_bar;
    }

    public void setId_bar(Integer id_bar) {
        this.id_bar = id_bar;
    }

    public BarModel(String nome, String telefone, String descricao, String cep, String cnpj, int id_pessoa) {
        this.nome = nome;
        this.telefone = telefone;
        this.descricao = descricao;
        this.cep = cep;
        this.cnpj = cnpj;
        this.avaliacao = 0;
        this.id_pessoa = id_pessoa;
    }

    public BarModel(){

    }
}

