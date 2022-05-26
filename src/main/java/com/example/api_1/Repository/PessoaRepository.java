package com.example.api_1.Repository;


import com.example.api_1.Model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaModel, Integer> {
}
