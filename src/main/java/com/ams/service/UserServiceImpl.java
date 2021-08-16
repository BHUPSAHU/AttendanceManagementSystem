package com.ams.service;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.entity.UserEntity;
import com.ams.exception.UserNotFoundException;
import com.ams.repository.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userRepo;

	static Supplier<Exception> userexp = () -> new UserNotFoundException("user not found based on id");

	// saving a specific record by using the method save()
	@Override
	@Transactional
	public long add(UserEntity user) {
		UserEntity tempUser = userRepo.save(user);
		return tempUser.getUserId();
	}

	// getting all records by using method findAll()
	@Override
	public List<UserEntity> userlist() {
		return userRepo.findAll();
	}

	// getting a specific record by using the method findById()
	@Override
	public UserEntity findById(Long id) throws Exception {
		return userRepo.findById(id).orElseThrow(userexp);
	}

	// updating a record
	@Override
	public void update(UserEntity user) throws Exception {
		UserEntity existingUser = userRepo.findById(user.getUserId()).orElseThrow(userexp);
		existingUser.setDob(user.getDob());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setMobileNo(user.getMobileNo());
		existingUser.setPassword(user.getPassword());
		existingUser.setProfilePic(user.getProfilePic());
		existingUser.setUserId(user.getUserId());
		existingUser.setRoleType(user.getRoleType());
		existingUser.setAssignFaculty(user.getAssignFaculty());
		userRepo.save(existingUser);
	}

	// deleting a specific record by using the method deleteById()
	@Override
	public void delete(Long userId) {
		userRepo.deleteById(userId);
	}

	// getting a specific record by using the method findByName()
	@Override
	public UserEntity findByFirstName(String userName) throws Exception {
		return userRepo.findByFirstName(userName);
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
