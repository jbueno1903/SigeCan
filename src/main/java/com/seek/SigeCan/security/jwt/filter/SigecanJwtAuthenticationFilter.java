package com.seek.SigeCan.security.jwt.filter;

import com.seek.SigeCan.security.jwt.provider.SigecanJwtTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * SigecanJwtAuthenticationFilter.
 * Description.
 *
 * @author : Julio Bueno
 * @version : 1.0 , 15/09/2024
 * @since : 1.0
 */
@Slf4j
@Component
public class SigecanJwtAuthenticationFilter extends OncePerRequestFilter {
  private final SigecanJwtTokenProvider sigecanJwtTokenProvider;

  public SigecanJwtAuthenticationFilter(SigecanJwtTokenProvider sigecanJwtTokenProvider) {
    this.sigecanJwtTokenProvider = sigecanJwtTokenProvider;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response, FilterChain filterChain) throws
      ServletException, IOException {
    log.info(request.getRequestURI());

    String jwtToken = extractJwtFromRequest(request);

    if (StringUtils.hasText(jwtToken) && sigecanJwtTokenProvider.validateToken(jwtToken)) {

      UserDetails userDetails = new
              User(sigecanJwtTokenProvider.getUsernameFromToken(jwtToken), "",
              sigecanJwtTokenProvider.getRolesFromToken(jwtToken));

      UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
          UsernamePasswordAuthenticationToken(userDetails,
          null, userDetails.getAuthorities());

      usernamePasswordAuthenticationToken.setDetails(
              sigecanJwtTokenProvider.getAllClaimsFromToken(jwtToken));

      SecurityContextHolder.getContext()
          .setAuthentication(usernamePasswordAuthenticationToken);
    }

    filterChain.doFilter(request, response);
  }

  private String extractJwtFromRequest(HttpServletRequest request) {
    String bearerToken = request.getHeader(sigecanJwtTokenProvider.AUTHORIZATION_HEADER);

    if (StringUtils.hasText(bearerToken) &&
        bearerToken.startsWith(sigecanJwtTokenProvider.BEARER_TOKEN)) {
      return bearerToken.substring(7);
    }

    return null;
  }
}
