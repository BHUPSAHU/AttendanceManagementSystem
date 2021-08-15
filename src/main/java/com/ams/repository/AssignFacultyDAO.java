package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ams.entity.FacultyEntity;

@Repository
public interface AssignFacultyDAO extends JpaRepository<FacultyEntity, Long> {

	public FacultyEntity findByUserName(String name);

}
