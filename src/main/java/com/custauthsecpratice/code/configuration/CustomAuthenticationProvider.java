package com.custauthsecpratice.code.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		UserDetails usd=userDetailsService.loadUserByUsername(authentication.getName());
		
		if(usd!=null && passwordEncoder.matches(authentication.getCredentials().toString(), usd.getPassword()))
		{
			System.out.println("gotcha first here ");
			
			return new UsernamePasswordAuthenticationToken(usd.getUsername(),usd.getPassword());
			
			
		}else {
			return (Authentication)new BadCredentialsException("Bad credentials");
		}
		
		
		
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
