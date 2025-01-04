package com.example.Student_New1.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Replace this with database user fetching logic
        if ("admin".equals(username)) {
            return new User("admin", "{noop}password", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
