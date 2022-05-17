package com.priyanka.jwt.api.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.priyanka.jwt.api.util.JwtUtil;
@Component
public class SecurityFilter extends OncePerRequestFilter {
	
    @Autowired
	private JwtUtil jwtutil;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
	@Override
	protected void doFilterInternal(
			HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain)
					throws ServletException, IOException {
		
		
		//1.Read token from Auth head
		
		String token = request.getHeader("Authorization");
		if(token!=null) {
			
			//do validation
			String username=jwtutil.getUsername(token);
			
			//username should not be empty , context-auth must be empty
			if(username!=null &&
					SecurityContextHolder.getContext()
					.getAuthentication() ==null)
			{
				UserDetails usr = userDetailsService.loadUserByUsername(username);
				
				//Validatetoken
				boolean isValid=jwtutil.validateToken(token, usr.getUsername());
				
				if(isValid) {
					UsernamePasswordAuthenticationToken authToken=
							new UsernamePasswordAuthenticationToken(
									username, usr.getPassword(),
									usr.getAuthorities() 
									);
					
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					//final object stored in SecurityContext with user Deatils(un,pwd)
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
		}
		filterChain.doFilter(request, response);
	}


}