package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.AnnualTurnOver;
import com.dxvalley.project.models.Federations;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface AnnualTurnOverService {

    AnnualTurnOver addAnnualTurnOver(AnnualTurnOver annualTurnOver);
    AnnualTurnOver editAnnualTurnOver (AnnualTurnOver annualTurnOver);
    List<AnnualTurnOver> getAnnualTurnOvers ();
    AnnualTurnOver getAnnualTurnOverById(Long annualTurnOverId);
    List<AnnualTurnOver> getAnnualTurnOverByUnion(Unions union);
    List<AnnualTurnOver> getAnnualTurnOverByPrCooperative(PrCooperative prCooperative);
    List<AnnualTurnOver> getAnnualTurnOverByFederation(Federations federation);
    void deleteAnnualTurnOver( Long annualTurnOverId);
    
}
