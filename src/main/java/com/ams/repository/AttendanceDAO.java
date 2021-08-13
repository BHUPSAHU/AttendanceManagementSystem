package com.ams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ams.entity.AttendanceEntity;

public interface AttendanceDAO extends JpaRepository<AttendanceEntity,Long> {

//	public AttendanceEntity findByStudentId(long id);
	
	@Query("select a from AttendanceEntity a order by a.studentId")
	public List<AttendanceEntity> findByStudentId(Long studentId);
	
	public AttendanceEntity findByStudentName(String name);
	
}
