package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.AnnualSell;

public interface AnnualSellRepository extends JpaRepository<AnnualSell, Long> {

    AnnualSell findAnnualSellByAnnualSellId(Long annualSellId);
    
}
