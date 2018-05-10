package com.jk.login.dao.impl;

import com.jk.login.dao.AccountDao;
import com.jk.login.model.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List query() {
        return sessionFactory.openSession().createQuery("from Account").list();
    }

    public void account(Account account) {
        sessionFactory.openSession().save(account);
    }
}
