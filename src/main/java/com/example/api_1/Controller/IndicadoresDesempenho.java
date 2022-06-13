package com.example.api_1.Controller;

import com.example.api_1.Api1Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class IndicadoresDesempenho {

    //Incompleta
    @Query(countQuery = "SELECT COUNT (id_pessoa) FROM pessoa", nativeQuery = true)
    abstract Integer quant_pessoas();

    //Incompleta
    @Query(countQuery = "SELECT COUNT (id_pagamento) FROM pagamento ", nativeQuery = true)
    abstract Integer quant_pagamentos();

    //Incompleta
    @Query(countQuery = "SELECT count (id_evento) FROM evento ", nativeQuery = true)
    abstract Integer quant_eventos();

    //Completa
    @Query(countQuery = "SELECT count (id_evento) FROM evento e WHERE e.id_bar_evento = ?1", nativeQuery = true)
    abstract Integer quant_eventos_por_bar(Integer id);



}
