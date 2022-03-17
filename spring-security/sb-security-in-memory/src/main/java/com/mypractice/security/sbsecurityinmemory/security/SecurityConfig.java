package com.mypractice.security.sbsecurityinmemory.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");

        http.authorizeRequests()
                .antMatchers("/hello").permitAll()
                .antMatchers("/{name}")
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

 /*   @Override
    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.inMemoryAuthentication()
                .withUser("nasruddin").password("nasruddin").authorities("admin")
                .and()
                .withUser("rehan").password("rehan").authorities("user")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {

        var inMemoryUserManager = new InMemoryUserDetailsManager();
        var firstUser = User.withUsername("nasruddin").password("nasruddin").authorities("admin").build();
        var secondUser = User.withUsername("maslu").password("maslu").authorities("read").build();
        inMemoryUserManager.createUser(firstUser);
        inMemoryUserManager.createUser(secondUser);
        managerBuilder.userDetailsService(inMemoryUserManager).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

}
