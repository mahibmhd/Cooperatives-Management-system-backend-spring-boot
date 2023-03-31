package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.AccountBalance;

public interface AccountBalanceRepository extends JpaRepository<AccountBalance,Long> {
    AccountBalance findAccountBalanceByAccountBalanceId(Long accountBalanceId);
    AccountBalance findAccountBalanceBydateGenerated(String dateGenerated);
}
