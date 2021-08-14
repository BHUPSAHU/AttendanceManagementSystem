package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ams.entity.UserEntity;

public interface UserDAO extends JpaRepository<UserEntity,Long>{
	public UserEntity findByFirstName(String name);
}
