package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String extractRole(String token) {
        return null; // mocked in tests
    }

    public String extractEmail(String token) {
        return null; // mocked in tests
    }

    public Long extractUserId(String token) {
        return null; // mocked in tests
    }

    public boolean validateToken(String token, String username) {
        if (token == null || username == null) {
            return false;
        }
        return true; // mocked in tests
    }

    // Dummy token generation (sufficient for project & swagger)
    public String generateToken(String email, String role, Long userId) {
        return "dummy-jwt-token";
    }
}
