package com.ams.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ams.entity.ERole;
import com.ams.entity.Role;

@Repository
public interface RoleDAO extends JpaRepository<Role,Long>{
	Optional<Role> findByName(ERole name);
}
