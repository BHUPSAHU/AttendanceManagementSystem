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

import com.ams.entity.StudentEntity;
import com.ams.exception.ErrorDetails;
import com.ams.service.StudentServiceImpl;

/**
 * @author Bhupesh Kumar Sahu
 *
 */
//mark class as controller

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class StudentController {

	// @Autowire the StudentService class

	@Autowired
	StudentServiceImpl studentService;

	@GetMapping("/student")
	public ResponseEntity<String> info() {
		String msg = "This path has Following URI services : ";
		ResponseEntity<String> str1 = new ResponseEntity<String>(msg, HttpStatus.OK);
		return str1;
	}

	// creating post mapping that adds to DB
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/student/add")
	public ResponseEntity<Long> addStudent(@Valid @RequestBody StudentEntity entity, BindingResult result) {
		if (result.hasErrors()) {
			ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), result.getFieldErrors().stream()
					.map(FieldError::getDefaultMessage).collect(Collectors.toList()).toString(),
					"ConstraintViolationException");
			return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
		}
		Long temp = studentService.add(entity);
		ResponseEntity<Long> responseEntity = new ResponseEntity<Long>(temp, HttpStatus.OK);
		return responseEntity;
	}

	// creating put mapping that update to DB
	@PutMapping("/student/update")
	public void updateStudent(@Valid @RequestBody StudentEntity entity) throws Exception {
		studentService.update(entity);
	}

	// creating delete mapping that deletes on DB
	@DeleteMapping("/student/delete/{id}")
	public void deleteStudent(@PathVariable("id") long id) {
		studentService.delete(id);
	}

	// creating get mapping through Student name
	@GetMapping("/student/byName/{name}")
	public ResponseEntity<StudentEntity> findStudentByName(@PathVariable("name") String name) {
		StudentEntity temp = studentService.findByName(name);
		ResponseEntity<StudentEntity> responseEntity = new ResponseEntity<StudentEntity>(temp, HttpStatus.OK);
		return responseEntity;
	}

	// creating get mapping through Student Id
	@GetMapping("/student/byId/{id}")
	public ResponseEntity<StudentEntity> findStudentByPk(@PathVariable("id") long id) throws Exception {
		StudentEntity temp = studentService.findByPk(id);
		ResponseEntity<StudentEntity> responseEntity = new ResponseEntity<StudentEntity>(temp, HttpStatus.OK);
		return responseEntity;
	}

	// fetch all student through Get mapping
	@GetMapping("/student/all")
	public ResponseEntity<List<StudentEntity>> findAllStudents() {
		List<StudentEntity> tempList = studentService.findAllStudents();
		ResponseEntity<List<StudentEntity>> responseEntity = new ResponseEntity<List<StudentEntity>>(tempList,
				HttpStatus.OK);
		return responseEntity;
	}
}
