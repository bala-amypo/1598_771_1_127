@Component
public class JwtUtil {
    private final String SECRET = "secret123";

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }
}
