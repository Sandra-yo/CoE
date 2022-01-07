package com.sandracoe.booklistapp.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.util.Arrays;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import com.sandracoe.booklistapp.Filter.JWTTokenGenerator;
import com.sandracoe.booklistapp.Filter.JWTValidator;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,  jsr250Enabled = true)
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
		cors().configurationSource(new CorsConfigurationSource() {
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration config = new CorsConfiguration();
				config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
				config.setAllowedMethods(Collections.singletonList("*"));
				config.setAllowCredentials(true);
				config.setAllowedHeaders(Collections.singletonList("*"));
				config.setExposedHeaders(Arrays.asList("access_token"));
				config.setMaxAge(3600L);
				return config;
			}
		}).and().csrf().disable()
				.addFilterBefore(new JWTValidator(), BasicAuthenticationFilter.class)
				.addFilterAfter(new JWTTokenGenerator(), BasicAuthenticationFilter.class)
		//		.addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
		//		.addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
		//		.addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
		//		.and()
				.authorizeRequests()
				.antMatchers("/books").hasRole("ADMIN")
				.antMatchers("/users").hasRole("ADMIN")
				.antMatchers("/categories").hasRole("ADMIN")
				.and().httpBasic();
	
	}
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
