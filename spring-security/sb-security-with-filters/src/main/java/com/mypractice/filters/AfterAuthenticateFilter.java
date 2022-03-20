package com.mypractice.filters;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
@Component
public class AfterAuthenticateFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("AfterAuthenticateFilter.doFilter start ");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            System.out.printf("user " + authentication.getName() + "has successfully authenticated to access the resource " + authentication.getAuthorities().toString());
        }
        System.out.printf("AfterAuthenticateFilter.doFilter end");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
