package com.service;

import com.domain.Role;

import java.util.List;

/**
 * @author 10574
 */
public interface RoleService {
    List<Role> findAll();

    void save(Role role);

    Role findById(Integer roleId);

    void savePermissionsToRole(Integer roleId, Integer[] ids);
}
