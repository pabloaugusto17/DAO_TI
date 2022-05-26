package com.example.api_1.Repository;

import com.example.api_1.Model.FuncionariosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionariosRepository extends JpaRepository<FuncionariosModel, Integer> {
}
