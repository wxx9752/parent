package com.jk.login.dao;

import com.jk.login.model.Power;

import java.util.List;

public interface WxxDao {
    List<Power> getTree(String sql, String name);
}
