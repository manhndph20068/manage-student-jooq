package com.example.managestudentjooq.sercurity.service;

import com.example.managestudentjooq.exception.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {
    @Value("${jwt.secret-key}")
    private String SECRET_KEY;

    @Value("${jwt.refresh-token-expiration-time-seconds}")
    private int REFRESH_TOKEN_EXPIRATION_TIME_SECONDS;

    @Value("${jwt.access-token-expiration-time-seconds}")
    private int ACCESS_TOKEN_EXPIRATION_TIME_SECONDS;

    public String extractToUserName(String token) {
        Claims claims = extractAllClaims(token);
        System.out.println("Claims: " + claims);
        if (claims == null) {
            throw new JwtException("Claims cannot be null");
        }
        return extractClaim(token, claims1 -> claims.get("username", String.class));
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        System.out.println("date" + claims.getExpiration());
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        try {
            return Jwts
                    .parserBuilder()
                    .setSigningKey(getSignKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (SignatureException e) {
            throw new InvalidTokenException("Invdfalid JWT signature");
        }
    }

    public String generateRefreshToken(String role, String userName) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put("username", userName);
        return buildRefreshToken(claims, userName);
    }

    public String generateAccessToken(String role, String userName) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put("username", userName);
        return buildAccessToken(claims, userName);
    }

    private String buildAccessToken(Map<String, Object> claims, String userName) {
        long currentTimeMillis = System.currentTimeMillis();
        long expirationMillis = currentTimeMillis + (ACCESS_TOKEN_EXPIRATION_TIME_SECONDS);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(expirationMillis))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }


    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        String username = extractToUserName(token);
        if (isTokenExpired(token)) {
            throw new ExpiredJwtException(null, null, "Token is expired");
        }
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public String buildRefreshToken(Map<String, Object> claims, String userName) {
        long currentTimeMillis = System.currentTimeMillis();
        long expirationMillis = currentTimeMillis + (REFRESH_TOKEN_EXPIRATION_TIME_SECONDS);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(expirationMillis))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }
}
