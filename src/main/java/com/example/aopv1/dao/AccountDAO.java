package com.example.aopv1.dao;

import com.example.aopv1.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(Account account, boolean flag);
    boolean doWork();
    void makeProgress();
    List<Account> findAccounts();
    List<Account> findAccounts(boolean breakCode);
}
