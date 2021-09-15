package com.ams.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ams.entity.User;
import com.ams.repository.UserLoginDAO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserLoginDAO userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		
		return UserDetailsImpl.build(user);
	}
	
//	@Override
//	@Transactional
//	public void forgotPassword(String username,String password,String email)throws UsernameNotFoundException {
//		System.out.println("============================ Entered forgot pass service============");
//		System.out.println("============================ user old password"+username+password);
//		User user=userRepository.findByUsername(username)
//				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
//		System.out.println("============================ user old password"+user.toString());
//		user.setUsername(username);
//		user.setEmail(email);
//		user.setPassword(password);
//		userRepository.save(user);
//		System.out.println("============================ user password"+user.toString());
//	}

}
