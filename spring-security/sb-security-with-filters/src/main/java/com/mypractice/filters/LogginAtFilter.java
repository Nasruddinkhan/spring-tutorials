package com.mypractice.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class LogginAtFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LogginAtFilter.doFilter start");
        System.out.printf("user validation is in progress");
        System.out.println("LogginAtFilter.doFilter end");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
