package com.example.jwtdemo.config;

import javax.crypto.SecretKey;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {
    private static final String SECRETE_KEY =
            "W6LbuTcwjpbtDlJjLw9XwjdUmh0ztaOM";

    public String extractUsername(String token) {
        return null;
    }

    private Claims extractAllClaims(String token) {
        // return Jwts.parserBuilder().setSigningKey(getSignInKey())
        // .build().parseClaimsJws(token).getBody();
        return Jwts.parser().verifyWith(getSignInKey()).build()
                .parseSignedClaims(token).getPayload();
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRETE_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
