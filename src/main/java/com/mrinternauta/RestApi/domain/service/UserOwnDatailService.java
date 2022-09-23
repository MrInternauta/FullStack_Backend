package com.mrinternauta.RestApi.domain.service;

import com.mrinternauta.RestApi.domain.dto.RolDomain;
import com.mrinternauta.RestApi.domain.dto.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserOwnDatailService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private RolService rolService;
    RolDomain rolDomain;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*UserDomain userDomain = userService.findByEmail(username);
        rolDomain = rolService.findByUserId(userDomain.getId());
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(rolDomain.getName()));
        return new User(userDomain.getEmail(), (userDomain.getPassword()),roles);*/
        UserDomain user = userService.findByEmail(username);

        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
