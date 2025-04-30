package com.test.elibrary.security;

import com.test.elibrary.entity.RoleEntity;
import com.test.elibrary.entity.UserEntity;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration-ms}")
    private long expirationMs;

    private Key key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    // 🔐 Generate Token
    public String generateToken(UserEntity user) {
        RoleEntity role = user.getRole(); // Now we can call user.getRole()
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("role", role.getName()) // Assuming RoleEntity has getName() method
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }


    // ✅ Validate Token
    public boolean isTokenValid(String token, UserEntity user) {
        final String username = extractUsername(token);
        return username.equals(user.getUsername()) && !isTokenExpired(token);
    }

    // 📥 Extract Username
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // 📥 Extract Expiration
    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
