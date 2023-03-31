package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{
    Account findAccountByAccountId(Long accountId);
    Account findAccountyByAccountNumber(String accountNumber);
}
