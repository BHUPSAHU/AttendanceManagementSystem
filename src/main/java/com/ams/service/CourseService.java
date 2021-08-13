package com.ams.service;

import java.util.List;

import com.ams.entity.CourseEntity;

public interface CourseService {
	public long add(CourseEntity entity);
	public void update(CourseEntity entity) throws Exception;
	public void delete(CourseEntity entity) throws Exception;
	public CourseEntity findByName(String name);
	public CourseEntity findByPk(long id) throws Exception;
	List<CourseEntity> findAllCourse();
}
