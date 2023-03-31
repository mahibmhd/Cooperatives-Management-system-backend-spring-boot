package com.dxvalley.project.services;

import java.util.List;
import com.dxvalley.project.models.PaidUpShare;

public interface PaidUpShareService {
    PaidUpShare addPaidUpShare (PaidUpShare paidUpShare);
    PaidUpShare editPaidUpShare (PaidUpShare paidUpShare);
    List<PaidUpShare> getPaidUpShare ();
    PaidUpShare getPaidUpShareById(Long paidUpShareId);
    void deletegetPaidUpShare( Long PaidUpShareId);
    
}
