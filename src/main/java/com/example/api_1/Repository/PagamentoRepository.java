package com.example.api_1.Repository;

import com.example.api_1.Model.PagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<PagamentoModel, Integer> {
}
