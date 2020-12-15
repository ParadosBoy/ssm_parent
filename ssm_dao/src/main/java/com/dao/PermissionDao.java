package com.dao;

import com.domain.Permission;
import com.domain.Role;

import java.util.List;

/**
 * @author 10574
 */
public interface PermissionDao {
    List<Permission> findAll();

    void save(Role role);
}
