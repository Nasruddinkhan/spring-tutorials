package com.mypractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
@EnableWebSecurity(debug = true)
@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * /myAccount - Secured /myBalance - Secured /myLoans - Secured /myCards -
	 * Secured /notices - Not Secured /contact - Not Secured
	 */
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
		}).and().csrf().ignoringAntMatchers("/contact").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.and().authorizeRequests()
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
