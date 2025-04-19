package com.example.sampleapi.user.data.service;

import com.example.sampleapi.user.data.model.CredentialsDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This service provides user information for authentication from db
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * This will give connection to repo
     */
    @Autowired
    private CredentialsService credentialsService;

    /**
     * Encryption for password its created in under @see com.example.sampleapi.user.config.StartupConfig
     */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Return the user for the username given from request
     *
     * @param username Username to fetch from DB
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CredentialsDataModel user = credentialsService.getUserByName(username);
        List<SimpleGrantedAuthority> role = new ArrayList<>(1);
        role.add(new SimpleGrantedAuthority(user.role));
        return new org.springframework.security.core.userdetails.User(
                user.userName, bCryptPasswordEncoder.encode(user.password), role);
    }
}
