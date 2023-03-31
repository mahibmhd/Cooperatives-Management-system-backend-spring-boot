package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Liabilty;

public interface LiabilityRepository extends JpaRepository<Liabilty,Long>{
    Liabilty findLiabiltyByLiabilityId(Long liabilityId);
}
