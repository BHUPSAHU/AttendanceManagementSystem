package com.ams.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ams.entity.AttendanceEntity;

public interface AttendanceDAO extends JpaRepository<AttendanceEntity,Long> {

//	public AttendanceEntity findByStudentId(long id);
	
	
	
	public AttendanceEntity findBySubjectName(String name);
	
}
