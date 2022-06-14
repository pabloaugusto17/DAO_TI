package com.example.api_1.Repository;

import com.example.api_1.Model.BarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BarRepository extends JpaRepository<BarModel, Integer> {

    @Query(nativeQuery = true, value = "SELECT f.id_funcionario FROM funcionario f" +
            " WHERE f.cnpj_bar = (:id_bar);")
    List<Integer> listIdFuncionarios(Integer id_bar);

}
