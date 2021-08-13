package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ams.entity.AssignFacultyEntity;

@Repository
public interface AssignFacultyDAO extends JpaRepository<AssignFacultyEntity, Long> {

	public AssignFacultyEntity findByUserName(String name);

}
