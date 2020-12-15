package com.service;

import com.domain.Permission;
import com.domain.Role;

import java.util.List;

/**
 * @author 10574
 */
public interface PermissionService {
    List<Permission> findAll();

    void save(Permission permission);

    List<Permission> findParentPermission();
}
