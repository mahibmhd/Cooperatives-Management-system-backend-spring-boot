package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.AnnualSell;

public interface AnnualSellService {
       
    AnnualSell addAnnualSell(AnnualSell annualSell);
    AnnualSell editAnnualSell (AnnualSell annualSell);
    List<AnnualSell> getAnnualSells ();
    AnnualSell getAnnualSellById(Long annualSellId);
    void deleteAnnuualSell( Long annualSellId);


}
