package com.dao;


import com.domain.Sysuser;

import java.util.List;

/**
 * @author 10574
 */
public interface UserDao {
    Sysuser findByUsername(String username);

    List<Sysuser> findAll();
}
