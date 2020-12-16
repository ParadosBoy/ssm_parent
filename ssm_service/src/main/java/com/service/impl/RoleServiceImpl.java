package com.service.impl;

import com.dao.RoleDao;
import com.domain.Role;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10574
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(Integer roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public void savePermissionsToRole(Integer roleId, Integer[] ids) {
        roleDao.delPermissionsFromRole(roleId);
        if (ids != null) {
            for (Integer permissionId : ids) {
                roleDao.savePermissionsToRole(roleId, permissionId);
            }
        }
    }
}
