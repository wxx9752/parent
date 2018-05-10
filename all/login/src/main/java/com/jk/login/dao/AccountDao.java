package com.jk.login.dao;

import com.jk.login.model.Account;

import java.util.List;

public interface AccountDao {

   List query();
   void account(Account account);
}
