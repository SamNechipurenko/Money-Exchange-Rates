package com.rates.exchange.service;

import com.rates.exchange.model.User;
import com.rates.exchange.repository.UserRepository;
import com.rates.exchange.security.CustomUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserService userService;

    public MyUserDetailsService(){

    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(userName);
        if (user == null) throw new UsernameNotFoundException("Username Not Found Exception");
        return new CustomUserPrincipal(user);
    }
}
