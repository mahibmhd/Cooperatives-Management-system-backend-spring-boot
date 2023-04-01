package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.OsLoan;

public interface OsLoanService {
    OsLoan addOsLoan (OsLoan osLoan);
    OsLoan editOsLoan (OsLoan osLoan);
    List<OsLoan> getOsLoans ();
    OsLoan getOsLoanById(Long osLoanId);
    //TotalCapital getTotalCapitalByName(String typeName);
    void deleteOsLoan( Long osLoanId);
}
