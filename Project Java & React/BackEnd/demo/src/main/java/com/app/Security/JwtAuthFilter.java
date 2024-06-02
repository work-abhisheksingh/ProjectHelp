package com.app.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;


@Component
public class JwtAuthFilter extends OncePerRequestFilter{

	Logger logger = org.slf4j.LoggerFactory.getLogger(JwtAuthFilter.class);
	
	@Autowired
	private JwtHelper jwtHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		//get token from header
		String requestToken = request.getHeader("Authorixation");
		
		logger.info("message () ", requestToken);
		String Username = null;
		String jwtToken = null;
		
		if(requestToken != null && requestToken.trim().startsWith("Bearer")) {
			//get actual token
			jwtToken= requestToken.substring(7);
			
			try {
				Username= this.jwtHelper.getusername(jwtToken);
				
			}catch(ExpiredJwtException e) {
				logger.info("Invalid Token Message" , "JWT token expired");
			}catch(MalformedJwtException e) {
				logger.info("Invalid Token Message","Invalid Jwt token");
			}catch (IllegalArgumentException e) {
				logger.info("Invalid Token Message","Unable to get token");
			}
			
			if(Username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				//validate userdetails
				
				UserDetails userdetails = this.userDetailsService.loadUserByUsername(Username);
				
				if(this.jwtHelper.validateToken(jwtToken, userdetails)) {
					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userdetails,null,userdetails.getAuthorities()) ;
					SecurityContextHolder.getContext().setAuthentication(auth);
					
				}else {
					logger.info("Not validate Message","Invalid Jwt token");
				}
			}
			
		}else {
			logger.info("User message", "username is null or auth is already there ");
		}
		filterChain.doFilter(request, response);
		
	}

	
}
