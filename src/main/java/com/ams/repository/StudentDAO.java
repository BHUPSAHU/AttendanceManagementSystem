package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ams.entity.StudentEntity;

public interface StudentDAO extends JpaRepository<StudentEntity,Long>{

	public StudentEntity findByName(String name);
}
