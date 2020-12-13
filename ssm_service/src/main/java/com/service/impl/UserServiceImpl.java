package com.service.impl;

import com.dao.UserDao;
import com.domain.Sysuser;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author 10574
 */
@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Sysuser user = userDao.findByUsername(username);
        if (user != null) {
            Collection<GrantedAuthority> list = new ArrayList<>();
            SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority("ROLE_USER");
            list.add(simpleGrantedAuthority);
            return new User(user.getUsername(), "{noop}" + user.getPassword(),list);
        }
        return null;
    }
}
