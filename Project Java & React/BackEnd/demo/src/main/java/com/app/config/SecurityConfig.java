package com.app.config;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.app.Security.JwtAuthFilter;
import com.app.Security.JwtAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailsService customuserdetailservice;
	public static String[] PUBLIC_URL = {"/api/**"};
	
	@Autowired
	private JwtAuthFilter filter;
	
	@Autowired
	private JwtAuthenticationEntryPoint entrypoint;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeHttpRequests().antMatchers(PUBLIC_URL).permitAll().
		anyRequest().authenticated().and().exceptionHandling().authenticationEntryPoint(entrypoint).and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(this.customuserdetailservice).passwordEncoder(passwordencoder());
	}
	
	//0000
	@Bean
	public PasswordEncoder  passwordencoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	@Bean
	public FilterRegistrationBean cosFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		
		CorsConfiguration configuration = new CorsConfiguration();
		
		configuration.setAllowCredentials(true);
		
		configuration.setAllowedHeaders(List.of(CorsConfiguration.ALL));
		
		configuration.addAllowedOriginPattern("*");
		
		configuration.addAllowedHeader("Authorization");
		
		configuration.addAllowedHeader("Context - Type");
		
		configuration.addAllowedHeader("Accept");
		
		
		configuration.addAllowedMethod("POST");
		configuration.addAllowedMethod("GET");
		configuration.addAllowedMethod("PUT");
		configuration.addAllowedMethod("DELETE");
		configuration.addAllowedMethod("OPTIONS");
		
		configuration.setMaxAge(3600L);
		
		source.registerCorsConfiguration("/**", configuration);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		
		bean.setOrder(-110);
		return bean;
		
	}
	
	

}
