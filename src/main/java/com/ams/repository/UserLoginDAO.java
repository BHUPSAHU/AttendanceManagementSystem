package com.ams.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ams.entity.User;


@Repository
public interface UserLoginDAO extends JpaRepository<User,Long>{
	Optional<User> findByUsername(String username);
	
	public User findByEmail(String email);
	
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	
}
