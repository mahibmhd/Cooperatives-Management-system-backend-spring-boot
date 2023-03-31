package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Commodity;

public interface CommodityRespository extends JpaRepository<Commodity,Long>{
    Commodity findCommodityByCommodityId(Long commodityId);
}
