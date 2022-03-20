package com.mypractice.filters;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Component
public class JWTTokenValidatorFilter extends OncePerRequestFilter {

    private static final String JWT_KEY = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";
    private static final String JWT_HEADER = "Authorization";

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String jwt = request.getHeader(JWT_HEADER);
        var auth = Optional.ofNullable(jwt)
                .map(JWTTokenValidatorFilter::getClaims)
                .map(JWTTokenValidatorFilter::getAuthentication)
                .orElseThrow(()->
                new BadCredentialsException("Invalid Token received!"));
        SecurityContextHolder.getContext().setAuthentication(auth);
        chain.doFilter(request, response);
    }

    private static Authentication getAuthentication(Claims claims) {
        String username = String.valueOf(claims.get("username"));
        String authorities = (String) claims.get("authorities");
        return new UsernamePasswordAuthenticationToken(username,null,
                AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));

    }

    private static Claims getClaims(String jwt) {
        SecretKey key = Keys.hmacShaKeyFor(
                JWT_KEY.getBytes(StandardCharsets.UTF_8));

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getServletPath().equals("/user"); }


}
