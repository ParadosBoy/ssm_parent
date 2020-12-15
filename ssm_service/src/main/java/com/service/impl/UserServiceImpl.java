package com.service.impl;

import com.dao.UserDao;
import com.domain.Sysuser;
import com.service.UserService;
import com.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author 10574
 */
@Service("userService")
public class UserServiceImpl implements UserDetailsService , UserService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Sysuser user = userDao.findByUsername(username);
        if (user != null) {
            Collection<GrantedAuthority> list = new ArrayList<>();
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
            list.add(simpleGrantedAuthority);
            return new User(user.getUsername(), user.getPassword(), list);
        }
        return null;
    }

    @Override
    public List<Sysuser> findAll() {
        return userDao.findAll();
    }

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public void save(Sysuser user) {
        String password = user.getPassword();
        /*String md5 = MD5Utils.md5(password);
        user.setPassword(md5);*/

        String encode = passwordEncoder.encode(password);
        user.setPassword(encode);
        userDao.save(user);
    }

    @Override
    public Sysuser findByUsernameCheck(String username) {
        return userDao.findByUsernameCheck();
    }

    @Override
    public Sysuser findById(Integer id) {
        return userDao.findById(id);
    }
}
