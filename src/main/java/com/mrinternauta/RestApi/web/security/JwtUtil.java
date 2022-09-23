package com.mrinternauta.RestApi.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private final String SEED = "Full-stack-seed";
    private final int EXPIRATION =  1000 *60 * 60 * 10;
    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SEED)
                .compact();
    }
    public boolean validateToken(String token , UserDetails userDetails){
        return userDetails.getUsername().equals(extractUserName(token)) && !isExpired(token);
    }

    public String extractUserName(String token){
        return getClaims(token).getSubject();

    }

    //Si no  ha expirado retorna false
    public boolean isExpired(String token){
        return getClaims(token).getExpiration().before(new Date());

    }

    //Obtener los datos
    public Claims getClaims(String token){
        return Jwts.parser().setSigningKey(SEED).parseClaimsJws(token).getBody();
    }
}
