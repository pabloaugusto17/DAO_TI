package com.example.api_1.Repository;

import com.example.api_1.Model.PagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PagamentoRepository extends JpaRepository<PagamentoModel, Integer> {

    @Query(nativeQuery = true, value = "SELECT COUNT(id_pagamento) AS cont FROM pagamento;")
    Integer quant_pagamentos();

}
