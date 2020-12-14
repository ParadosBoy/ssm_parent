package com.service;

import com.domain.Sysuser;

import java.util.List;

public interface UserService {
    List<Sysuser> findAll();

    void save(Sysuser user);
}
