package com.example.user.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.user.model.Role;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.example.user.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
	private UserRepository userRepository;
	
	
	
	public UserServiceImpl(UserRepository userRepository) { 
		super();
		this.userRepository = userRepository;
	}



	@Override
	public User save(UserRegistrationDto registrationDto) {
		
				User user = new User(registrationDto.getFirstName(), 
						registrationDto.getLastName(), registrationDto.getEmail(),
						(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
				
				return userRepository.save(user);
			}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
	
	         return null;

	}
}

 

 
