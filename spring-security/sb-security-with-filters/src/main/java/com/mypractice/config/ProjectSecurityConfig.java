package com.mypractice.config;

import com.mypractice.filters.AfterAuthenticateFilter;
import com.mypractice.filters.LogginAtFilter;
import com.mypractice.filters.RequestBeforeValidatorFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;
@EnableWebSecurity(debug = true)
@Configuration
@AllArgsConstructor
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	private final RequestBeforeValidatorFilter requestBeforeValidatorFilter;
	private final AfterAuthenticateFilter afterAuthenticateFilter;
	private final LogginAtFilter logginAtFilter;
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().configurationSource(request -> {
			CorsConfiguration config = new CorsConfiguration();
			config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
			config.setAllowedMethods(Collections.singletonList("*"));
			config.setAllowCredentials(true);
			config.setAllowedHeaders(Collections.singletonList("*"));
			config.setMaxAge(3600L);
			return config;
		})
				.and().csrf().ignoringAntMatchers("/contact").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.and()
				.addFilterBefore(requestBeforeValidatorFilter , BasicAuthenticationFilter.class)
				.addFilterAfter(afterAuthenticateFilter, BasicAuthenticationFilter.class)
				.addFilterAt(logginAtFilter, BasicAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers("/myAccount").hasRole("USER")
				.antMatchers("/myBalance").hasAnyRole("USER","ADMIN")
				.antMatchers("/myLoans").hasRole("ROOT")
				.antMatchers("/myCards").authenticated()
				.antMatchers("/user").authenticated()
				.antMatchers("/notices").permitAll()
				.antMatchers("/contact").permitAll()
				.and()
				.httpBasic()
				.and()
				.formLogin();
	}
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
