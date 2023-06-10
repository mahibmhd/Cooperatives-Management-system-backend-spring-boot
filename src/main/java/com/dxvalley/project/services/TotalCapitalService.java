package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.TotalCapital;
import com.dxvalley.project.models.Unions;

public interface TotalCapitalService {
    TotalCapital addTotalCapital (TotalCapital totalCapital);
    TotalCapital editTotalCapital (TotalCapital totalCapital);
    List<TotalCapital> getTotalCapitals ();
    TotalCapital getTotalCapitalById(Long totalCapitalId);
   List<TotalCapital> getTotalCapitalByPrCooperative(PrCooperative prCooperative);
   List<TotalCapital> geTotalCapitalByUnion(Unions union);
    void deleteTotalCapital( Long totalCapitalId);
}
