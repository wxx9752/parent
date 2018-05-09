package com.jk.login.action;
import com.jk.login.model.Account;
import com.jk.login.service.AccountService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@ParentPackage("struts-default")
@Namespace("/")
@Action(value = "test",results = {
        @Result(name = "account",location = "/show.jsp")
})
public class AccountAction extends BaseAction{

    @Autowired
    private AccountService service;


    private List list;


    public String  toShow(){
        list = service.query();
        return  "account";
    }
    public String toAddAccount(Account account){

        service.addAccount(account);

        return "";
    }

    public List getList() {
        return list;
    }



}
