package com.ams.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.entity.CourseEntity;
import com.ams.exception.CourseNotFoundException;
import com.ams.repository.CourseDAO;

@Service
public class CourseServiceImpl implements CourseService {

	Supplier<Exception> s1 = () -> new CourseNotFoundException("Course Not Found in DataBase");

	@Autowired
	private CourseDAO sub;

	// saving a specific record by using the method save()
	@Override
	public long add(CourseEntity course) {
		CourseEntity c = sub.save(course);
		return c.getCourseId();

	}

	// updating a record
	@Override
	public void update(CourseEntity course) throws Exception {
		long id = course.getCourseId();
		CourseEntity c = sub.findById(id).orElseThrow(s1);
		c.setCourseId(course.getCourseId());
		c.setCourseName(course.getCourseName());
		c.setDescription(course.getDescription());
		sub.save(c);
	}

	// deleting a specific record by using the method deleteById()
	@Override
	public long delete(long id) throws Exception {
		sub.deleteById(id);
		return id;
	}

	// getting a specific record by using the method findByName()
	@Override
	public CourseEntity findByName(String courseName) {
		CourseEntity c = sub.findByCourseName(courseName);
		return c;
	}

	// getting a specific record by using the method findById()
	@Override
	public CourseEntity findByPk(long courseId) throws Exception {
		CourseEntity c = sub.findById(courseId).orElseThrow(s1);
		return c;
	}

	// getting all records by using method findAll()
	@Override
	public List<CourseEntity> findAllCourse() {
		List<CourseEntity> subList = sub.findAll();
		return subList;
	}

}
