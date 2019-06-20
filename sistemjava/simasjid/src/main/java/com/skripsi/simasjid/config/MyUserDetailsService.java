package com.skripsi.simasjid.config;

import com.skripsi.simasjid.model.ModelAnggota;
import com.skripsi.simasjid.services.ServiceAnggota2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    ServiceAnggota2 serviceAnggota2;

    public MyUserDetailsService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ModelAnggota user = serviceAnggota2.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found by name: " + username);
        }
        UserDetails ud = User.builder()
                .username(username)
                // This should contain the hashed password for the requested user
                .password(user.getPassword())
                // If you don't need roles, just provide a default one, eg. "USER"
                .roles("USER")
                .build();


        return ud;
    }
}