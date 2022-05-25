package com.api_rest_drunk_drink.Model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FuncionariosModel extends PessoaModel{

    @Column
    private double avaliacao;

    @Column (length = 200)
    private String dados_bancarios;

    @Column (length = 200)
    private String descricao;

    @NotNull
    @Column
    @Id
    @GeneratedValue
    private Integer id_funcionario;

    @Column
    private Integer cnpj_barEvento;

    @Column
    private double preco_hora;

    public FuncionariosModel(String nome, Integer cpf, String senha, String endereco, String telefone, String email, double avaliacao, String dados_bancarios, String descricao, Integer id_funcionario, Integer cnpj_barEvento, double preco_hora) {
        super(nome, cpf, senha, endereco, telefone, email);
        this.avaliacao = avaliacao;
        this.dados_bancarios = dados_bancarios;
        this.descricao = descricao;
        this.id_funcionario = id_funcionario;
        this.cnpj_barEvento = cnpj_barEvento;
        this.preco_hora = preco_hora;
    }

    public FuncionariosModel(){

    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDados_bancarios() {
        return dados_bancarios;
    }

    public void setDados_bancarios(String dados_bancarios) {
        this.dados_bancarios = dados_bancarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Integer id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public Integer getCnpj_barEvento() {
        return cnpj_barEvento;
    }

    public void setCnpj_barEvento(Integer cnpj_barEvento) {
        this.cnpj_barEvento = cnpj_barEvento;
    }

    public double getPreco_hora() {
        return preco_hora;
    }

    public void setPreco_hora(double preco_hora) {
        this.preco_hora = preco_hora;
    }
}
