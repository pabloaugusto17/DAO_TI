package com.api_rest_drunk_drink.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "pessoa")
@Inheritance (strategy = InheritanceType.JOINED)
public class PessoaModel implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id_pessoa;
    @Column(length = 50, name = "nome")
    private String nome;
    @Column (length = 15, name = "cpf")
    private String cpf;
    @Column(length = 20, name = "senha")
    private String senha;
    @Column(length = 50, name = "endereco")
    private String endereco;
    @Column (name = "telefone", length = 50)
    private String telefone;
    @Column(length = 30, name = "email")
    private String email;

    public PessoaModel(){

    }

    public PessoaModel(String nome, String cpf, String senha, String endereco, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public Integer getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(Integer id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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
