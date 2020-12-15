package com.dao;

import com.domain.Role;

import java.util.List;

/**
 * @author 10574
 */
public interface RoleDao {

    List<Role> findAll();


    void save(Role role);

    List<Role> findRoleByUserId(Integer userId);
}
