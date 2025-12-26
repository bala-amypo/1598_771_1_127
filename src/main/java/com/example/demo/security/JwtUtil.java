package com.example.demo.security;

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

    // Optional: real JWT generation (not used in tests)
    public String generateToken(String email, String role, Long userId) {
        return "dummy-token";
    }
}
