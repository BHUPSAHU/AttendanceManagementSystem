package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ams.entity.CourseEntity;

public interface CourseDAO extends JpaRepository<CourseEntity,Long>{

	 CourseEntity  findByCourseName(String courseName);
}
