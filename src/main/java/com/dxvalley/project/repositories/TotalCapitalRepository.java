package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.TotalCapital;

public interface TotalCapitalRepository extends JpaRepository<TotalCapital,Long>{
    TotalCapital findTotalCapitalByTotalCapitalId(Long totalCapitalId);
}
