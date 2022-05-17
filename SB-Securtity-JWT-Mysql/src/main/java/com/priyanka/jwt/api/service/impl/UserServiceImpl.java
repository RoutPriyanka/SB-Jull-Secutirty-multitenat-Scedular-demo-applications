package com.priyanka.jwt.api.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.priyanka.jwt.api.model.User;
import com.priyanka.jwt.api.repo.UserRepository;
import com.priyanka.jwt.api.service.IUserService;
@Service
public class UserServiceImpl implements IUserService,UserDetailsService{
 
    @Autowired
	private UserRepository repo; //Has-A
    
    @Autowired
    private BCryptPasswordEncoder pwdEncoder;
    
    //save method
    @Override
	public Integer saveUser(User user) 
	{
		//Encode password
    	user.setPassword(
    	pwdEncoder.encode(
    			user.getPassword())
    	);
		return repo.save(user).getId();
	}
    //get user by username
    @Override
    public Optional<User> findByUsername(String username) {
    	
    	return repo.findByUsername(username);
    }
    
    //--------------------------//
    @Override
    public UserDetails loadUserByUsername(String username) 
    		throws UsernameNotFoundException 
    {
         Optional<User> opt =findByUsername(username);
         if(opt.isEmpty())
        	 throw new UsernameNotFoundException("User not exit");
         
        //read user (from DB)
         User user = opt.get();
    	return new org.springframework.security.core.userdetails.User(
    			 username,
    			 user.getPassword(),
    			 user.getRoles().stream()
    			 .map(role->new SimpleGrantedAuthority(role))
    			 .collect(Collectors.toList())
    					 );
    }

}
