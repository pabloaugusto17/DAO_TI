package com.example.api_1.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name = "pessoa")
public class PessoaModel implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
    @Column(name="data_registro")
    private String data_registro;

    public PessoaModel(){

    }

    public PessoaModel(String nome, String cpf, String senha, String endereco, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;

        Date data_atual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(data_atual);
        this.data_registro = data;

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

    public String getData_registro() {
        return data_registro;
    }

    public void setData_registro(String data_registro) {
        this.data_registro = data_registro;
    }
}
