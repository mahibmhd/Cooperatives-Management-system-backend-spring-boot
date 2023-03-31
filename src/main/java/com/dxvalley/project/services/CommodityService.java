package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Commodity;

public interface CommodityService {
    Commodity addCommodity (Commodity commodity);
    Commodity editCommodity (Commodity commodity);
    List<Commodity> getCommodities ();
    Commodity getCommodityById(Long commodityId);
    //Member getTypeByName(String typeName);
    void deleteCommodity( Long commodityId);
}
