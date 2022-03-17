package com.mypractice.security.sbsecuritybasic.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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

        /* not allow if you have provide proper username & password
       http.authorizeRequests()
               .anyRequest()
               .denyAll()
               .and()
               .formLogin()
               .and()
               .httpBasic();
    */
        // allow for all user which is authorized or not
      /* http.authorizeRequests()
               .anyRequest()
               .permitAll()
               .and()
               .formLogin()
               .and()
               .httpBasic();*/

    }
}
