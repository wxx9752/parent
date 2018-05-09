package com.jk.login.service;

import java.util.List;
import com.jk.login.model.Power;

public interface WxxService {
    List<Power> getTree(String name);
}
