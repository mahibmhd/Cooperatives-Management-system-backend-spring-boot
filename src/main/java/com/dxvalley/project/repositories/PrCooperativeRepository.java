package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.PrCooperative;

public interface PrCooperativeRepository extends JpaRepository<PrCooperative, Long> {
   
    PrCooperative findPrCooperativeByPrCooperativeId (Long prCooperative_Id);
    PrCooperative findPrCooperativeByName(String name);
    
}
