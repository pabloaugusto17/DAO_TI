package com.api_rest_drunk_drink.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "pessoa")
public class PessoaModel {

    @Column(length = 50)
    private String nome;
    @Id
    private Integer cpf;
    @Column(length = 20)
    private String senha;
    @Column(length = 50)
    private String endereco;
    @Column
    private String telefone;
    @Column(length = 30)
    private String email;

    public PessoaModel(String nome, Integer cpf, String senha, String endereco, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public PessoaModel() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
