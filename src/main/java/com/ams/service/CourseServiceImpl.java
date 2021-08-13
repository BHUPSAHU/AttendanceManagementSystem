package com.ams.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.entity.CourseEntity;
import com.ams.exception.RecordNotFoundException;
import com.ams.repository.CourseDAO;

@Service
public class CourseServiceImpl implements CourseService{
	
	Supplier<Exception> s1 = ()-> new RecordNotFoundException("Course Not Found in DataBase");

	
	@Autowired
	private CourseDAO sub;

	@Override
	public long add(CourseEntity course) 
	{
		CourseEntity c = sub.save(course);
		return c.getCourseId();

	}

	@Override
	public void update(CourseEntity course) throws Exception {
		long id = course.getCourseId();
		CourseEntity c = sub.findById(id).orElseThrow(s1);
		c.setCourseId(course.getCourseId());
		c.setCourseName(course.getCourseName());
		c.setDescription(course.getDescription());
		sub.save(c);
	}

	@Override
	public void delete(CourseEntity course) throws Exception 
	{
		CourseEntity c = sub.findById(course.getCourseId()).orElseThrow(s1);
		sub.delete(c);
	}

	@Override
	public CourseEntity findByName(String courseName) {
		CourseEntity c =  sub.findByCourseName(courseName);
		return c;
	}

	@Override
	public CourseEntity findByPk(long courseId) throws Exception {
		CourseEntity c = sub.findById(courseId).orElseThrow(s1);
		return c;
	}

	@Override
	public List<CourseEntity> findAllCourse() {
		List<CourseEntity> subList = sub.findAll();
		return subList;
	}


}
