package com.example.aopv1.dao;

import com.example.aopv1.Account;
import org.springframework.stereotype.Repository;

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
}
