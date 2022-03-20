package com.mypractice.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestBeforeValidatorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("RequestBeforeValidatorFilter.doFilter start");
        request.getHeaderNames().asIterator().forEachRemaining(System.out::println);
        System.out.printf("write some logic for validating all request");
        System.out.println("RequestBeforeValidatorFilter.doFilter end");
        filterChain.doFilter(request, response);

    }

}
