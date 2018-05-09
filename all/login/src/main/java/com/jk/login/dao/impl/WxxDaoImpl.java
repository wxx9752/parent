package com.jk.login.dao.impl;


import com.jk.login.dao.WxxDao;
import com.jk.login.model.Power;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WxxDaoImpl implements WxxDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Power> getTree(String hql) {
        return sessionFactory.getCurrentSession().createQuery(hql).list();
    }
}
