package com.ams.service;

import java.util.List;

import com.ams.entity.UserEntity;

public interface UserService {
	
	public long add(UserEntity user);

	public UserEntity findById(Long id) throws Exception;

	public void update(UserEntity user) throws Exception;

	public void delete(Long userId);

	public Boolean authenticate(String userName);

	public Boolean forgotPassword(String userName);

	public UserEntity findByFirstName(String name) throws Exception;

	public List<UserEntity> userlist();
}
