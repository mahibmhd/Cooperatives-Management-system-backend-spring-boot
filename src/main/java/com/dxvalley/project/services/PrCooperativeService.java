package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.PrCooperative;

public interface PrCooperativeService {
    PrCooperative addPrCooperative(PrCooperative prCooperative);
    PrCooperative editPrCooperative(PrCooperative prCooperative);
    List<PrCooperative> getPrCooperative ();
    PrCooperative getPrCooperativeById (Long prCooperativeId);
    PrCooperative getPrCooperativeByName(String name);
    void deletePrCooperative(Long prCooperativeId);

}


