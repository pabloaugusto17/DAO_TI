package com.example.api_1.Repository;

import com.example.api_1.Model.BartenderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BartenderRepository extends JpaRepository<BartenderModel, Integer> {
}
