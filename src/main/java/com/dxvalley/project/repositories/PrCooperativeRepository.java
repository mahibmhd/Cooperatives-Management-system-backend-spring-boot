package com.dxvalley.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Federations;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface PrCooperativeRepository extends JpaRepository<PrCooperative, Long> {
   
    PrCooperative findPrCooperativeByPrCooperativeId (Long prCooperative_Id);
    PrCooperative findPrCooperativeByName(String name);
    List<PrCooperative> findPrCooperativeByUnion(Unions union);
    List<PrCooperative> findPrCooperativeByUnionAndIsActive(Unions union,Boolean isActive);
    List<PrCooperative> findPrCooperativesByFederationAndIsActive(Federations federation,Boolean isActive);
    List<PrCooperative> findPrCooperativesByFederation(Federations federation);
    
}
