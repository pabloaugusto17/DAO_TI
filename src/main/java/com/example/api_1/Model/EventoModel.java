package com.example.api_1.Model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity(name = "evento")
public class EventoModel {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_evento;
	
	@Column
	private Integer id_bar_evento;
	
	@Column
	private Integer id_contratante_evento;
	
	@Column
    private String nome;

    @Column
    private String endereco;

    @Column
    private String hora_inicio;

    @Column(name = "quant_participantes")
    private Integer quantidade_participantes;

    @Column
    private double duracao;

    @Column
    private String hora_termino;

    @Column
    private String data_evento;

    public EventoModel(Integer id_bar_evento, Integer id_contratante_evento, String nome, String endereco, String hora_inicio, Integer quantidade_participantes, double duracao, String hora_termino) {
        this.id_bar_evento = id_bar_evento;
        this.id_contratante_evento = id_contratante_evento;
        this.nome = nome;
        this.endereco = endereco;
        this.hora_inicio = hora_inicio;
        this.quantidade_participantes = quantidade_participantes;
        this.duracao = duracao;
        this.hora_termino = hora_termino;

        Date data_atual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(data_atual);
        this.data_evento = data;
    }

    public EventoModel() {
    }

    public Integer getId_evento() {
        return id_evento;
    }

    public void setId_evento(Integer id_evento) {
        this.id_evento = id_evento;
    }

    public Integer getId_bar_evento() {
        return id_bar_evento;
    }

    public void setId_bar_evento(Integer id_bar_evento) {
        this.id_bar_evento = id_bar_evento;
    }

    public Integer getId_contratante_evento() {
        return id_contratante_evento;
    }

    public void setId_contratante_evento(Integer id_contratante_evento) {
        this.id_contratante_evento = id_contratante_evento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Integer getQuantidade_participantes() {
        return quantidade_participantes;
    }

    public void setQuantidade_participantes(Integer quantidade_participantes) {
        this.quantidade_participantes = quantidade_participantes;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public String getHora_termino() {
        return hora_termino;
    }

    public void setHora_termino(String hora_termino) {
        this.hora_termino = hora_termino;
    }

    public String getData_evento() {
        return data_evento;
    }

    public void setData_evento(String data_evento) {
        this.data_evento = data_evento;
    }
}
