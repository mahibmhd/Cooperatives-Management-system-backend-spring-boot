package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Federations;
import com.dxvalley.project.models.PaidUpShare;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface PaidUpShareService {
    PaidUpShare addPaidUpShare (PaidUpShare paidUpShare);
    PaidUpShare editPaidUpShare (PaidUpShare paidUpShare);
    List<PaidUpShare> getPaidUpShare ();
    PaidUpShare getPaidUpShareById(Long paidUpShareId);
    List<PaidUpShare> getPaidUpShareByUnion(Unions union);
    List<PaidUpShare> getPaidUpShareByPrCooperative(PrCooperative prCooperative);
    List<PaidUpShare> getPaidUpShareByFederation(Federations federation);
    void deletegetPaidUpShare( Long PaidUpShareId);
    
}
