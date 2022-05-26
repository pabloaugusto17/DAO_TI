package com.example.api_1.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "contratante_evento")
public class ContratanteEventoModel {

    @Id
    private Integer contratante_evento_id;

    public ContratanteEventoModel(Integer contratante_evento_id) {
        this.contratante_evento_id = contratante_evento_id;
    }

    public ContratanteEventoModel() {
    }

    public Integer getContratante_evento_id() {
        return contratante_evento_id;
    }

    public void setContratante_evento_id(Integer contratante_evento_id) {
        this.contratante_evento_id = contratante_evento_id;
    }
}
