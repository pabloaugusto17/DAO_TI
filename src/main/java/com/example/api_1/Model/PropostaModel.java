package com.example.api_1.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "proposta")
public class PropostaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proposta;

    @Column
    private Integer id_contratante;

    @Column
    private Integer id_bar;

    @Column
    private String descricao;

    @Column
    private int status;

    @Column
    private Integer id_evento;

    @Column
    private Integer id_func;

    public PropostaModel(Integer id_geral, Integer id_bar, String descricao, Integer id_evento, String tipo) {

        if(tipo.equals("CE")){
            this.id_contratante = id_geral;
        }else if(tipo.equals("FUNC")){
            this.id_func = id_geral;
        }

        this.id_bar = id_bar;
        this.descricao = descricao;

        if(tipo.equals("CE")){
            this.id_evento = id_evento;
        }

    }

    public PropostaModel(){

    }

    public Integer getId_proposta() {
        return id_proposta;
    }

    public void setId_proposta(Integer id_proposta) {
        this.id_proposta = id_proposta;
    }

    public Integer getId_contratante() {
        return id_contratante;
    }

    public void setId_contratante(Integer id_contratante) {
        this.id_contratante = id_contratante;
    }

    public Integer getId_bar() {
        return id_bar;
    }

    public void setId_bar(Integer id_bar) {
        this.id_bar = id_bar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getId_evento() {
        return id_evento;
    }

    public void setId_evento(Integer id_evento) {
        this.id_evento = id_evento;
    }
}
