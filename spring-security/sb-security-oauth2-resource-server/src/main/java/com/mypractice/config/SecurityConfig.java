package com.mypractice.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.web.cors.CorsConfiguration;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@AllArgsConstructor
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final KeycloakRoleConverter keycloakRoleConverter;

    private static CorsConfiguration getCorsConfiguration(HttpServletRequest HttpServletRequest) {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setMaxAge(3600L);
        return config;
    }

    /**
     * /myAccount - Secured /myBalance - Secured /myLoans - Secured /myCards -
     * Secured /notices - Not Secured /contact - Not Secured
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(keycloakRoleConverter);
        http.cors().configurationSource(SecurityConfig::getCorsConfiguration
        ).and()
                .authorizeRequests()
                .antMatchers("/myAccount").hasAnyRole("USER")
                .antMatchers("/myBalance").hasAnyRole("ADMIN")
                .antMatchers("/myLoans").authenticated()
                .antMatchers("/myCards", "/token").hasAnyRole("USER", "ADMIN")
                .antMatchers("/notices").permitAll()
                .antMatchers("/contact").permitAll()
                .and().csrf().disable()
                .oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);
        http.headers().frameOptions().sameOrigin();

    }

}
