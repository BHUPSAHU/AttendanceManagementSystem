package com.ams.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ams.entity.User;
import com.ams.repository.UserLoginDAO;
import com.ams.security.services.UserDetailsServiceImpl;

@Service
public class UserLoginService {
	
	@Autowired
	UserLoginDAO userRepository;
	
	@Autowired
	UserDetailsServiceImpl userimpl;

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
	
	public void forgotPassword(String username,String password,String email){
		System.out.println("============================ Entered forgot pass service============");
		System.out.println("============================ user old password"+username+password);
		User user=userRepository.findByEmail(email);
		System.out.println("================= user found "+user.toString());
//		User updateuser= new User(user.getUsername(),email,user.getPassword());
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		userRepository.save(user);
//		userRepository.save(updateuser);
		System.out.println("============================ updated user "+user.toString());
		
	}
}
