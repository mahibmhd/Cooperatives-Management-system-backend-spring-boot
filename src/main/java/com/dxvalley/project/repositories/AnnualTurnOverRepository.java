package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.AnnualTurnOver;

public interface AnnualTurnOverRepository extends JpaRepository<AnnualTurnOver, Long>  { 

    AnnualTurnOver findAnnualTurnOverByAnnualTurnOverId(Long annualTurnOverId);
    
}
