package com.example.api_1.Repository;

import com.example.api_1.Model.EventoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventoRepository extends JpaRepository<EventoModel, Integer> {

    @Query(nativeQuery = true, value = "SELECT COUNT(e.id_evento) AS quant FROM evento e"
            + " WHERE e.data_evento LIKE '___06%';")
    Integer quant_eventos_mes();

    @Query(nativeQuery = true, value = "SELECT COUNT(e.id_evento) AS quant FROM evento e;")
    Integer quant_eventos_total();

}
