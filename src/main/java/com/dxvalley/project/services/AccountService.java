package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Account;

public interface AccountService {
    Account addAccount(Account account);
    Account editAccount (Account account);
    List<Account> getAccounts ();
    Account getAccountById(Long accountId);
    Account getAccountByAccountNumber(String accountNumber);
    void deleteAccount( Long accountId);
}
