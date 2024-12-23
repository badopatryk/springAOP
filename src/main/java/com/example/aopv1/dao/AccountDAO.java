package com.example.aopv1.dao;

import com.example.aopv1.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean flag);
    boolean doWork();
    void makeProgress();
}
