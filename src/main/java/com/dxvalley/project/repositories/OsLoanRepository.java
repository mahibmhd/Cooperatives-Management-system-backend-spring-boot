package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.OsLoan;

public interface OsLoanRepository extends JpaRepository<OsLoan,Long> {
    OsLoan findOsLoanByOsLoanId(Long osLoanId);
}
