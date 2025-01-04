package com.example.Student_New1.Configure;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtAuthenticationToken implements Authentication {
    private final UserDetails userDetails;
    private boolean authenticated;

    // Constructor for JwtAuthenticationToken
    public JwtAuthenticationToken(UserDetails userDetails, boolean authenticated) {
        this.userDetails = userDetails;
        this.authenticated = authenticated; // This will be true if the JWT is valid
    }

    @Override
    public String getName() {
        return userDetails.getUsername(); // Return the username (principal) of the authenticated user
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userDetails.getAuthorities(); // Return authorities (roles/permissions)
    }

    @Override
    public Object getCredentials() {
        return null; // No credentials are needed in JWT-based authentication
    }

    @Override
    public Object getPrincipal() {
        return userDetails; // Return the UserDetails object containing user info
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated; // Return the authentication status
    }

    @Override
    public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
        this.authenticated = authenticated; // Set authentication status (it should be true after valid JWT)
    }

    @Override
    public Object getDetails() {
        return null; // or provide relevant details if needed
    }

    // Optional: You can override hashCode and equals if needed for token
    // comparison, but it's usually not required
}
