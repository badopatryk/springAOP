package com.example.aopv1.dao;

import com.example.aopv1.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass() + ", database access: adding an account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ", doWork()");
        return false;
    }

    public void makeProgress() {
        System.out.println(getClass() + ", makeProgress()");
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean breakCode) {

        if (breakCode) {
            throw new RuntimeException("EXCEPTION!!!");
        }

        List<Account> myAccounts = new ArrayList<>();

        Account account1 = new Account("John", "First");
        Account account2 = new Account("Major", "Third");
        Account account3 = new Account("Kris", "Second");

        myAccounts.add(account1);
        myAccounts.add(account2);
        myAccounts.add(account3);

        return myAccounts;
    }
}
