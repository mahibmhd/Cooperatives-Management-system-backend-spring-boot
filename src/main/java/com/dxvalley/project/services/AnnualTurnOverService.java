package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.AnnualTurnOver;

public interface AnnualTurnOverService {

    AnnualTurnOver addAnnualTurnOver(AnnualTurnOver annualTurnOver);
    AnnualTurnOver editAnnualTurnOver (AnnualTurnOver annualTurnOver);
    List<AnnualTurnOver> getAnnualTurnOvers ();
    AnnualTurnOver getAnnualTurnOverById(Long annualTurnOverId);
    void deleteAnnualTurnOver( Long annualTurnOverId);
    
}
