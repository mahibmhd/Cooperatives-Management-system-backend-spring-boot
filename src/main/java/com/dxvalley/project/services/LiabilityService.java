package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Liabilty;

public interface LiabilityService {
    Liabilty addLiabilty(Liabilty liabilty);
    Liabilty editLiabilty (Liabilty liabilty);
    List<Liabilty> getLiabilties ();
    Liabilty getLiabiltyById(Long liabiltyId);
    //Member getTypeByName(String typeName);
    void deleteLiabilty( Long liabiltyId);
}
