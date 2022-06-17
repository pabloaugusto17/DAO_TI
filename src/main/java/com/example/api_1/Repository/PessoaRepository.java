package com.example.api_1.Repository;


import com.example.api_1.Model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRepository extends JpaRepository<PessoaModel, Integer> {

    @Query(nativeQuery = true, value = "SELECT COUNT(p.id_pessoa) AS quant FROM pessoa p"
    + " WHERE p.data_registro LIKE '___06%';")
    Integer quant_cadastros_mes();

    @Query(nativeQuery = true, value = "SELECT COUNT(p.id_pessoa) AS quant FROM pessoa p;")
    Integer quant_cadastros_total();

}
