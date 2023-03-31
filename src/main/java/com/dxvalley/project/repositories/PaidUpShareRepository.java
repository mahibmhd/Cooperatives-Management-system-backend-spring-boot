package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.PaidUpShare;

public interface PaidUpShareRepository extends JpaRepository<PaidUpShare, Long>{
    PaidUpShare findPaidUpShareByPaidUpId(Long paidUpShareId); 
  
}

