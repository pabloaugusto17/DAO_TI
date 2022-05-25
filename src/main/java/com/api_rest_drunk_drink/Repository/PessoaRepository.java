package com.api_rest_drunk_drink.Repository;

import com.api_rest_drunk_drink.Model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaModel, Integer> {
}
