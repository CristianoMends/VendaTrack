package com.api.vendas_track.application.service;

import com.api.vendas_track.application.useCases.TokenUseCases;
import com.api.vendas_track.domain.user.User;
import com.api.vendas_track.domain.user.UserRepository;
import com.api.vendas_track.infrastructure.exception.BusinessException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;

@Service
public class TokenServiceImpl implements TokenUseCases {

    @Value("${security.config.key}")
    private String secretKey;
    @Value("${security.config.expiration}")
    private int expireTime;

    @Autowired
    private UserRepository userRepository;

    private final Set<String> invalidatedTokens = new HashSet<>();

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.create()
                    .withIssuer("vendas-api")
                    .withSubject(user.getEmail())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new BusinessException("Error while generating token", exception);
        }
    }

    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(expireTime).toInstant(ZoneOffset.of("-03:00"));
    }

    public String validateToken(String token) {
        if (isTokenInvalidated(token)) {
            throw new BusinessException("Token has been invalidated.");
        }

        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.require(algorithm)
                    .withIssuer("pix-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    public User getUserFromToken(String token) {
        String email = validateToken(token);
        if (email.isEmpty()) {
            throw new BusinessException("Invalid or expired token");
        }

        return (User) userRepository.findByEmail(email).orElseThrow(
                () -> new BusinessException("User not found")
        );
    }

    public void invalidateToken(String token) {
        if (validateToken(token).isEmpty()) {
            throw new BusinessException("Cannot invalidate an already invalid or expired token.");
        }
        invalidatedTokens.add(token);
    }

    private boolean isTokenInvalidated(String token) {
        return invalidatedTokens.contains(token);
    }
}
