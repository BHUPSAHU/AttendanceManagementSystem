package com.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ams.entity.CourseEntity;
import com.ams.service.CourseServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class CourseController {
	@Autowired
	CourseServiceImpl courseservice;

	@GetMapping("/course")
	public ResponseEntity<String> info() {
		String msg = "This path has Following URI services : ";
		ResponseEntity<String> str1 = new ResponseEntity<String>(msg, HttpStatus.OK);
		return str1;
	}
	
	@PostMapping("/course/add")
	public ResponseEntity<Long> addCourse(@RequestBody CourseEntity course) {
		long c1 = courseservice.add(course);
		ResponseEntity<Long> re = new ResponseEntity<Long>(c1, HttpStatus.OK);
		return re;
	}

	@PutMapping("/course/update")
	public void updateCourse(@RequestBody CourseEntity course) throws Exception {
		courseservice.update(course);

	}

	@DeleteMapping("/course/delete")
	public void deleteCourse(@RequestBody CourseEntity course) throws Exception {
		courseservice.delete(course);
	}

	@GetMapping("/course/byId/{id}")
	public ResponseEntity<CourseEntity> findSubjectById(@PathVariable("id") long id) throws Exception {
		CourseEntity c1 = courseservice.findByPk(id);
		ResponseEntity<CourseEntity> re = new ResponseEntity<CourseEntity>(c1, HttpStatus.OK);
		return re;
	}

	@GetMapping("/course/byName/{name}")
	public ResponseEntity<CourseEntity> findCourseByCourseName(@PathVariable("name") String name) {
		CourseEntity c1 = courseservice.findByName(name);
		ResponseEntity<CourseEntity> re = new ResponseEntity<CourseEntity>(c1, HttpStatus.OK);
		return re;
	}

	@GetMapping("/course/all")
	public ResponseEntity<List<CourseEntity>> findAllSubject() {
		List<CourseEntity> list = courseservice.findAllCourse();
		ResponseEntity<List<CourseEntity>> re = new ResponseEntity<List<CourseEntity>>(list, HttpStatus.OK);
		return re;
	
	}
	

}