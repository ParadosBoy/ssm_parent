package com.dao;


import com.domain.Sysuser;

import java.util.List;

/**
 * @author 10574
 */
public interface UserDao {
    Sysuser findByUsername(String username);

    List<Sysuser> findAll();

    void save(Sysuser user);

    Sysuser findByUsernameCheck(String username);

    Sysuser findById(Integer id);

    void delRoleFromUser(Integer userId);

    void savaRoleToUser(Integer roleId, Integer userId);
}
