package com.example.api_1.Repository;

import com.example.api_1.Model.BarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarRepository extends JpaRepository<BarModel, Integer> {
}
