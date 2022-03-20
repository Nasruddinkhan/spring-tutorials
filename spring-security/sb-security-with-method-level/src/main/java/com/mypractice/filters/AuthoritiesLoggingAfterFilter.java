package com.mypractice.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@Component
public class AuthoritiesLoggingAfterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("<========= AuthoritiesLoggingAfterFilter doFilter start ========> ");
        Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .ifPresent((authentication)-> System.out.println("User "+authentication.getName()+" is successfully authenticated and "
                        + "has the authorities "+authentication.getAuthorities().toString()));
        log.info("<========= AuthoritiesLoggingAfterFilter doFilter end ========> ");
        chain.doFilter(request, response);
    }

}