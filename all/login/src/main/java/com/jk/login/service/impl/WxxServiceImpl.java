package com.jk.login.service.impl;



import com.jk.login.dao.WxxDao;
import com.jk.login.model.Power;
import com.jk.login.service.WxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxxServiceImpl implements WxxService {
    @Autowired
    private WxxDao wxxdao;

    public List<Power> getTree(String name) {
     /* String hql="SELECT DISTINCT tp.* FROM  User tu \n" +
                "\t\t\tLEFT JOIN User_Role ur ON ur.u_id=tu.u_id\n" +
                "\t\t\tLEFT JOIN Role tr ON ur.r_id=tr.r_id\n" +
                "\t\t\tLEFT JOIN Role_Power rp ON rp.r_id=tr.r_id\n" +
                "\t\t\tLEFT JOIN POWER tp ON tp.p_id=rp.p_id\n" +
                "\t\t\twhere tu.u_username='"+name+"'";*/
     String hql =" from Power ";

        return wxxdao.getTree(hql);
    }
}
