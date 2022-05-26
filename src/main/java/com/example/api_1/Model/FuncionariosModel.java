package com.example.api_1.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity (name = "funcionario")
public class FuncionariosModel {

    @Column (name = "avaliacao")
    private double avaliacao;

    @Column (length = 200, name = "dados_bancarios")
    private String dados_bancarios;

    @Column (length = 200, name = "descricao")
    private String descricao;

    @Id
    private Integer id_funcionario;

    @Column (name = "cnpj_bar_evento")
    private Integer cnpj_bar_evento;

    @Column (name = "preco_hora")
    private double preco_hora;

    public FuncionariosModel(double avaliacao, String dados_bancarios, String descricao, Integer id_funcionario, Integer cnpj_barEvento, double preco_hora) {

        this.avaliacao = avaliacao;
        this.dados_bancarios = dados_bancarios;
        this.descricao = descricao;
        this.id_funcionario = id_funcionario;
        this.cnpj_bar_evento = cnpj_bar_evento;
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
        return cnpj_bar_evento;
    }

    public void setCnpj_bar_evento(Integer cnpj_barEvento) {
        this.cnpj_bar_evento = cnpj_barEvento;
    }

    public double getPreco_hora() {
        return preco_hora;
    }

    public void setPreco_hora(double preco_hora) {
        this.preco_hora = preco_hora;
    }
}
