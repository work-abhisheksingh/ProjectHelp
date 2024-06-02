package com.app.Security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtHelper {

	public static final long JWT_TOKEN_VALIDITY = 5*60*60 ;  //by default in millisec
	
	private String secret = "JwtTokenKey";
	
	//retrieve usr name
	public String getusername(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	//expire date
	public Date getexpirationdatefromtoken(String token) {
		return getClaimFromToken(token , Claims::getExpiration);
	}
	
	///check  token has expire
	
	private boolean isTokenExpired (String token) {
		final Date date = getexpirationdatefromtoken(token);
		
		return date.before(new Date());
	}
	
	//genetrate token for user
	
	public String generateToken(UserDetails userdetails) {
		
		Map<String , Object> claims= new HashMap<>();
		
		return doGenerateToken(claims, userdetails.getUsername());
	}
	
	//check for safe url
	private String doGenerateToken(Map<String , Object> claims , String subject) {
		
		return Jwts.builder().setClaims(claims).setSubject(subject).
				setIssuedAt(new Date(System.currentTimeMillis())).
				setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();	
		
	}
	
	//validate token
	public Boolean validateToken(String token , UserDetails userDetails) {
		final String username = getusername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	public <T> T getClaimFromToken(String token , Function<Claims , T> claimsResolver) {
		
		final Claims claims= getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	

	private Claims getAllClaimsFromToken (String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
}
