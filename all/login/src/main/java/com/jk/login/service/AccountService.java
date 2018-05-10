package com.jk.login.service;

import com.jk.login.model.Account;

import java.util.List;

public interface AccountService {


    List query();
    void addAccount(Account account);

}
