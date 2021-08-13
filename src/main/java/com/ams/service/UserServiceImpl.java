package com.ams.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.entity.UserEntity;
import com.ams.exception.RecordNotFoundException;
import com.ams.repository.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userRepo;
	
	static Supplier<Exception> userexp=()->new RecordNotFoundException("user not found based on id");

	
	@Override
	public long add(UserEntity user) {
		UserEntity tempUser =  userRepo.save(user);
		return tempUser.getUserId();
	}
	
	@Override
	public List<UserEntity> userlist(){
		return userRepo.findAll();
	}
	
	@Override
	public UserEntity findById(Long id) throws Exception{
		return userRepo.findById(id).orElseThrow(userexp);
	}
	
	@Override
	public void update(UserEntity user) throws Exception {
		UserEntity existingUser=userRepo.findById(user.getUserId()).orElseThrow(userexp);
		existingUser.setDob(user.getDob());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setMobileNo(user.getMobileNo());
		existingUser.setPassword(user.getPassword());
		existingUser.setProfilePic(user.getProfilePic());
		existingUser.setUserId(user.getUserId());
		existingUser.setRoleType(user.getRoleType());
		existingUser.setUserName(user.getUserName());
		
		 
		userRepo.save(existingUser);		
	}
	
	@Override
	public void delete(Long userId){
	  userRepo.deleteById(userId);
	}

	@Override
	public UserEntity findByUserName(String userName) throws Exception{
		return userRepo.findByUserName(userName);
	}
	
	@Override
	public Boolean authenticate(String userName) {
		
		return true;
	}
	
	@Override
	public Boolean forgotPassword(String userName) {
		return true;
	}
	
	
}
