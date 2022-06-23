package com.example.api_1.Repository;

import com.example.api_1.Model.ContratanteEventoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContratanteEventoRepository  extends JpaRepository<ContratanteEventoModel, Integer> {

    @Query(nativeQuery = true, value = "SELECT COUNT(id_evento) AS cont " +
    "FROM evento E WHERE E.id_contratante_evento = (:id_ce) ")
    Integer quant_eventos_CE(Integer id_ce);

}
