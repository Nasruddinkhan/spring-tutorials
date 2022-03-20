package com.mypractice.config;

import com.mypractice.filters.*;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;

@EnableWebSecurity(debug = true)
@AllArgsConstructor
@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true, securedEnabled = true)
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

    private final RequestValidationBeforeFilter requestBeforeValidatorFilter;
    private final AuthoritiesLoggingAfterFilter afterAuthenticateFilter;
    private final AuthoritiesLoggingAtFilter logginAtFilter;
    private final JWTTokenGeneratorFilter jwtTokenGeneratorFilter;
    private final JWTTokenValidatorFilter jwtTokenValidatorFilter;

	private static CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Collections.singletonList("*"));
		config.setExposedHeaders(Arrays.asList("Authorization"));
		config.setMaxAge(3600L);
		return config;
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
                cors().configurationSource(ProjectSecurityConfig::getCorsConfiguration).and().csrf().disable()
                .addFilterBefore(requestBeforeValidatorFilter, BasicAuthenticationFilter.class)
                .addFilterAfter(afterAuthenticateFilter, BasicAuthenticationFilter.class)
                .addFilterBefore(jwtTokenValidatorFilter, BasicAuthenticationFilter.class)
                .addFilterAfter(jwtTokenGeneratorFilter, BasicAuthenticationFilter.class)
                .addFilterAt(logginAtFilter, BasicAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/myAccount").hasRole("USER")
                .antMatchers("/myBalance").hasAnyRole("USER", "ADMIN")
                .antMatchers("/myLoans").hasRole("ROOT")
                .antMatchers("/myCards").hasAnyRole("USER", "ADMIN")
                .antMatchers("/user").authenticated()
                .antMatchers("/notices").permitAll()
                .antMatchers("/contact").permitAll().and().httpBasic();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
