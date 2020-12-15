package com.service;

import com.domain.Sysuser;

import java.util.List;

/**
 * @author 10574
 */
public interface UserService {
    List<Sysuser> findAll();

    void save(Sysuser user);


    Sysuser findByUsernameCheck(String username);
}
