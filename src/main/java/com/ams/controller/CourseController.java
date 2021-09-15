package com.ams.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ams.entity.CourseEntity;
import com.ams.exception.ErrorDetails;
import com.ams.service.CourseServiceImpl;


/**
 * @author Aishwarya K
 *
 */
//mark class as controller

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {
	// @Autowire the CourseService class
	@Autowired
	CourseServiceImpl courseservice;

	@GetMapping("/course")
	public ResponseEntity<String> info() {
		String msg = "This path has Following URI services : ";
		ResponseEntity<String> str1 = new ResponseEntity<String>(msg, HttpStatus.OK);
		return str1;
	}
	// creating post mapping that adds to DB
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/course/add")
	public ResponseEntity<Long> addCourse(@Valid @RequestBody CourseEntity course, BindingResult result) {
		if(result.hasErrors()) {
			ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),result.getFieldErrors().stream().map(FieldError :: getDefaultMessage).collect(Collectors.toList()).toString() ,"ConstraintViolationException"); 
			return  new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);
		}
		long c1 = courseservice.add(course);
		ResponseEntity<Long> re = new ResponseEntity<Long>(c1, HttpStatus.OK);
		return re;
	}
	// creating put mapping that update to DB
	@PutMapping("/course/update")
	public void updateCourse(@RequestBody CourseEntity course) throws Exception {
		courseservice.update(course);

	}
	// creating delete mapping that deletes on DB
	@DeleteMapping("/course/delete/{id}")
	public void deleteCourse(@PathVariable("id") long id) throws Exception {
		courseservice.delete(id);
	}
	// creating get mapping through Course Id
	@GetMapping("/course/byId/{id}")
	public ResponseEntity<CourseEntity> findSubjectById(@PathVariable("id") long id) throws Exception {
		CourseEntity c1 = courseservice.findByPk(id);
		ResponseEntity<CourseEntity> re = new ResponseEntity<CourseEntity>(c1, HttpStatus.OK);
		return re;
	}
	// creating get mapping through Course Name
	@GetMapping("/course/byName/{name}")
	public ResponseEntity<CourseEntity> findCourseByCourseName(@PathVariable("name") String name) {
		CourseEntity c1 = courseservice.findByName(name);
		ResponseEntity<CourseEntity> re = new ResponseEntity<CourseEntity>(c1, HttpStatus.OK);
		return re;
	}
	// fetch all course through Get mapping
	@GetMapping("/course/all")
	public ResponseEntity<List<CourseEntity>> findAllSubject() {
		List<CourseEntity> list = courseservice.findAllCourse();
		ResponseEntity<List<CourseEntity>> re = new ResponseEntity<List<CourseEntity>>(list, HttpStatus.OK);
		return re;
	
	}
	

}
