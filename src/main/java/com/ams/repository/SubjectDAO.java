package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ams.entity.SubjectEntity;

public interface SubjectDAO extends JpaRepository<SubjectEntity,Long>{
	
	   public SubjectEntity findBySubjectName(String subjectName);
	   
}
