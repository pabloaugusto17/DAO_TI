package com.example.api_1.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "bartender")
public class BartenderModel {

    @Id
    private Integer id_bartender;

    public BartenderModel(Integer id_bartender) {
        this.id_bartender = id_bartender;
    }

    public BartenderModel(){

    }

    public Integer getId_bartender() {
        return id_bartender;
    }

    public void setId_bartender(Integer id_bartender) {
        this.id_bartender = id_bartender;
    }
}
