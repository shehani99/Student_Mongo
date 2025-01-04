package com.example.Student_New1.Configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.Student_New1.Utill.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // Extract the Authorization header
        String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String jwt = null;

        // Check if the header contains Bearer token
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7); // Extract JWT token
            username = jwtUtil.extractUsername(jwt); // Extract username from token
        }

        // If a valid JWT is found and there's no authentication in the security context
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Load user details from the UserDetailsService
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // Validate the JWT token
            if (jwtUtil.isTokenValid(jwt, userDetails.getUsername())) {
                // If the token is valid, create an authentication token and set it in the
                // security context
                JwtAuthenticationToken token = new JwtAuthenticationToken(userDetails, null,
                        userDetails.getAuthorities());
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // Attach additional
                                                                                              // details to the token
                SecurityContextHolder.getContext().setAuthentication(token); // Set the authentication in the security
                                                                             // context
            }
        }

        // Continue with the filter chain
        chain.doFilter(request, response);
    }

}
