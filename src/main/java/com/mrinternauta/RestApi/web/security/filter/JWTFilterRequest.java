package com.mrinternauta.RestApi.web.security.filter;

import com.mrinternauta.RestApi.domain.service.UserOwnDatailService;
import com.mrinternauta.RestApi.web.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

@Component
public class JWTFilterRequest extends OncePerRequestFilter {
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    UserOwnDatailService userOwnDatailService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwt = authorizationHeader.substring(7);
            String username = this.jwtUtil.extractUserName(jwt);

            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = this.userOwnDatailService.loadUserByUsername(username);

                if(this.jwtUtil.validateToken(jwt, userDetails)){
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }

        filterChain.doFilter(request, response);
    }

    /*@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer")){
            String  jwt = authHeader.substring(7);
            String username = jwtUtil.extractUserName(jwt);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = userOwnDatailService.loadUserByUsername(username);
                if (jwtUtil.validateToken(jwt, userDetails)){
                    UsernamePasswordAuthenticationToken authToken  = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }*/
}
