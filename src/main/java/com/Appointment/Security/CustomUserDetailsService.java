package com.Appointment.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.Appointment.Entity.User;
import com.Appointment.Services.IUserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = userService.getUserbyEmail(email);
        if (u == null) {
            throw new UsernameNotFoundException("User not found: " + email);
        }

        
        return org.springframework.security.core.userdetails.User
                .withUsername(u.getEmail())
                .password(u.getPassword())
                .authorities(u.getRole().name()) 
                .build();
    }
}
