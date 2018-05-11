package com.jk.login.action;
import com.alibaba.fastjson.JSON;
import com.jk.login.model.Account;
import com.jk.login.service.AccountService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
@ParentPackage("struts-default")
@Namespace("/test")
public class AccountAction extends BaseAction{

    @Autowired
    private AccountService service;

    private List list;

    private Account asd = new Account();

    public Account getAsd() {
        return asd;
    }

    public void setAsd(Account asd) {
        this.asd = asd;
    }

    @Action(value = "toShow")
    public void  toShow(){
        List list = service.query();


        // System.out.print(list);
        String jsonStr= JSON.toJSONString(list);
        try {
            ServletActionContext.getResponse().setCharacterEncoding("utf-8");
            ServletActionContext.getResponse().getWriter().write(jsonStr);

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    @Action(value = "toAddAccount")
    public void toAddAccount(){

        service.addAccount(asd);

    }

    public List getList() {
        return list;
    }

}
