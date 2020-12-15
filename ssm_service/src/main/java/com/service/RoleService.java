package com.service;

import com.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void save(Role role);
}
