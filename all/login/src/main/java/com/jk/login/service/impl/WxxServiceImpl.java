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
     String sql="SELECT DISTINCT tp.* FROM  six.user tu \n" +
             "                LEFT JOIN user_role ur ON ur.u_id=tu.u_id\n" +
             "                LEFT JOIN Role tr ON ur.r_id=tr.r_id\n" +
             "                LEFT JOIN Role_Power rp ON rp.r_id=tr.r_id\n" +
             "                LEFT JOIN test.POWER tp ON tp.id=rp.p_id\n" +
             "                WHERE tu.u_username=?";
   /* String hql =" from Power ";*/

        return wxxdao.getTree(sql,name);
    }
}
