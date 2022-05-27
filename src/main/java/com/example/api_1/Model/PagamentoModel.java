package com.example.api_1.Model;

import javax.persistence.*;


@Entity(name = "pagamento")
public class PagamentoModel {

    @Column (name = "id_remetente")
    private Integer id_remetente;

    @Column (name = "id_destinatario")
    private Integer id_destinatario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pagamento;

    @Column (name = "valor")
    private double valor;

    public PagamentoModel(Integer id_remetente, Integer id_destinatario, double valor) {
        this.id_remetente = id_remetente;
        this.id_destinatario = id_destinatario;
        this.valor = valor;
    }

    public PagamentoModel() {
    }

    public Integer getId_remetente() {
        return id_remetente;
    }

    public void setId_remetente(Integer id_remetente) {
        this.id_remetente = id_remetente;
    }

    public Integer getId_destinatario() {
        return id_destinatario;
    }

    public void setId_destinatario(Integer id_destinatario) {
        this.id_destinatario = id_destinatario;
    }

    public Integer getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(Integer id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
