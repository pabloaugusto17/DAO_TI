package com.example.api_1.Repository;

import com.example.api_1.Model.PropostaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PropostaRepository extends JpaRepository<PropostaModel, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM proposta P WHERE P.id_bar = (:id_bar)")
    List<PropostaModel> recebe_proposta_bar(Integer id_bar);

    @Query(nativeQuery = true, value = "SELECT * FROM proposta P WHERE P.id_contratante = (:id_ce)")
    List<PropostaModel> recebe_proposta_ce(Integer id_ce);

    @Query(nativeQuery = true, value = "SELECT id_proposta FROM proposta WHERE id_contratante = (:id_ce) AND id_bar = (:id_bar)")
    Integer retorna_id_proposta(Integer id_ce, Integer id_bar);

    @Query(nativeQuery = true, value = "SELECT  * FROM proposta WHERE id_evento = (:id_evento)")
    List<PropostaModel> recebe_proposta_evento(Integer id_evento);

    @Query(nativeQuery = true, value = "SELECT  * FROM proposta WHERE id_proposta = (:id_proposta)")
    PropostaModel recebe_proposta(Integer id_proposta);

}
