package com.seek.SigeCan.security.jwt.provider;

import com.seek.SigeCan.authentication.infrastructure.out.persistence.entity.UserEntityJpa;
import com.seek.SigeCan.exception.BadRequestException;
import com.seek.SigeCan.security.jwt.dto.SigecanUserJwt;
import com.seek.SigeCan.security.jwt.properties.SigecanJwtProperties;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * SigecanJwtTokenProvider.
 * Description.
 *
 * @author : Julio Bueno
 * @version : 1.0 , 14/09/2024
 * @since : 1.0
 */
@Component
public class SigecanJwtTokenProvider {
  public static final String AUTHORITIES_KEY = "auth";
  public static final String AUTHORIZATION_HEADER = "Authorization";
  public static final String BEARER_TOKEN = "Bearer ";
  private static final ConcurrentHashMap<String, Key> keyCache = new ConcurrentHashMap<>();
  private final SigecanJwtProperties sigecanJwtProperties;

  public SigecanJwtTokenProvider(SigecanJwtProperties sigecanJwtProperties) {
    this.sigecanJwtProperties = sigecanJwtProperties;
  }

  public String generateToken(UserEntityJpa userEntityJpa) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("userId", userEntityJpa.getId());
    claims.put("userName", userEntityJpa.getUserName());
    claims.put("organizationId", "1");
    claims.put("sessionId",userEntityJpa.getSessionId());
    claims.put("auth", "USER");
    claims.put("sub", userEntityJpa.getId());
    return doGenerateToken(claims);
  }

  private String doGenerateToken(Map<String, Object> claims) {
    Key key = keyCache.computeIfAbsent(sigecanJwtProperties.getBase64Secret(),
        k -> Keys.hmacShaKeyFor(Decoders.BASE64.decode(k)));
    long now = System.currentTimeMillis();

    return Jwts.builder()
        .setClaims(claims)
        .setIssuedAt(new Date(now))
        .setExpiration(getExpirationTime(now,
                sigecanJwtProperties.getTokenValidityInSeconds()))
        .signWith(key, SignatureAlgorithm.HS512)
        .compact();

  }

  private Date getExpirationTime(long now, long tokenValidityInSeconds) {
    long expirationTime = now + tokenValidityInSeconds * 1000;
    return new Date(expirationTime);
  }

  public String doGenerateRefreshToken(Map<String, Object> claims, String subject,
                                       String authorities) {
    Key key = keyCache.computeIfAbsent(sigecanJwtProperties.getBase64Secret(),
        k -> Keys.hmacShaKeyFor(Decoders.BASE64.decode(k)));
    long now = System.currentTimeMillis();

    return Jwts.builder()
        .setClaims(claims)
        .setSubject(subject)
        .claim(AUTHORITIES_KEY, authorities)
        .setIssuedAt(new Date(now))
        .setExpiration(
            getExpirationTime(now, sigecanJwtProperties.getRefreshTokenValidityInSeconds()))
        .signWith(key, SignatureAlgorithm.HS512)
        .compact();
  }

  public boolean validateToken(String token) {
    try {
      Key key = keyCache.computeIfAbsent(sigecanJwtProperties.getBase64Secret(),
          k -> Keys.hmacShaKeyFor(Decoders.BASE64.decode(k)));
      Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
      return true;
    } catch (SignatureException | MalformedJwtException | UnsupportedJwtException |
             IllegalArgumentException ex) {
      throw new BadRequestException("authentication.invalid.credentials");
    } catch (ExpiredJwtException ex) {
      throw ex;
    }
  }

  public String getUsernameFromToken(String token) {
    return getClaimFromToken(token, Claims::getSubject);
  }

  public List<SimpleGrantedAuthority> getRolesFromToken(String token) {
    Key key = keyCache.computeIfAbsent(sigecanJwtProperties.getBase64Secret(),
        k -> Keys.hmacShaKeyFor(Decoders.BASE64.decode(k)));
    Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    List<SimpleGrantedAuthority> authorities =
        Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
            .map(SimpleGrantedAuthority::new)
            .toList();
    return authorities;
  }

  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }


  public Claims getAllClaimsFromToken(String token) {
    Key key = keyCache.computeIfAbsent(sigecanJwtProperties.getBase64Secret(),
        k -> Keys.hmacShaKeyFor(Decoders.BASE64.decode(k)));
    return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
  }

  public String getTokenFromRequest(HttpServletRequest request) {
    String token = null;
    String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
    if (org.springframework.util.StringUtils.hasText(bearerToken) &&
        bearerToken.startsWith(BEARER_TOKEN)) {
      token = bearerToken.substring(7);
    }
    return token;
  }

}
