package com.jk.login.service.impl;

import com.jk.login.dao.AccountDao;
import com.jk.login.model.Account;
import com.jk.login.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountDao accountDao;

    public List query() {
        return accountDao.query();
    }

    public void addAccount(Account account) {
        accountDao.account(account);
    }
}
