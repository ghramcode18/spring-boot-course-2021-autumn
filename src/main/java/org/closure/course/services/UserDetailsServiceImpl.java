package org.closure.course.services;

import java.util.Optional;

import org.closure.course.config.UserDetailsImpl;
import org.closure.course.entities.User;
import org.closure.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("password bcrypty : "+passwordEncoder.encode("admin@123"));
		Optional<User> user = userRepository.findByUserName(userName);

		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

		// return user.map((e)-> new UserDetailsImpl(e)).get(); // the same of return statement
		return user.map(UserDetailsImpl::new).get();
	
	}

}