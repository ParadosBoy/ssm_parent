package com.dao;


import com.domain.Sysuser;

/**
 * @author 10574
 */
public interface UserDao {
    Sysuser findByUsername(String username);
}
