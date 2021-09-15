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

import com.ams.entity.FacultyEntity;
import com.ams.exception.ErrorDetails;
import com.ams.exception.CourseNotFoundException;
import com.ams.service.AssignFacultyServiceImpl;

/**
 * @author Manjari
 *
 */
//mark class as controller

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AssignFacultyController {
	// @Autowire the SubjectService class
	@Autowired
	AssignFacultyServiceImpl assignfacultyservice;

	@GetMapping("/faculty")
	public ResponseEntity<String> info() {
		String msg = "This path has Following URI services : ";
		ResponseEntity<String> str1 = new ResponseEntity<String>(msg, HttpStatus.OK);
		return str1;
	}

	// fetch all subjects through Get mapping
	@GetMapping("/faculty/all")
	public List<FacultyEntity> getAllFaculty() throws CourseNotFoundException {
		return assignfacultyservice.findAllAssignFaculty();
	}

	// creating post mapping that adds to DB
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(path = "/faculty/add")
	public ResponseEntity<Long> create(@Valid @RequestBody FacultyEntity assignfaculty, BindingResult result) {
		if (result.hasErrors()) {
			ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), result.getFieldErrors().stream()
					.map(FieldError::getDefaultMessage).collect(Collectors.toList()).toString(),
					"ConstraintViolationException");
			return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
		}
		long id = assignfacultyservice.add(assignfaculty);
		ResponseEntity<Long> re = new ResponseEntity<Long>(id, HttpStatus.OK);
		return re;
	}

	// creating put mapping that update to DB
	@PutMapping("/faculty/update")
	public void update(@RequestBody FacultyEntity faculty) throws Exception {
		assignfacultyservice.update(faculty);
	}

	// creating delete mapping that deletes on DB
	@DeleteMapping("/faculty/delete/{id}")
	public void deleteAssignFaculty(@PathVariable("id") Long id) throws Exception {
		assignfacultyservice.delete(id);
	}

	// creating get mapping through subjectId
	@GetMapping("/faculty/byId/{id}")
	public ResponseEntity<FacultyEntity> getFacultyById(@PathVariable("id") Long id) throws Exception {
		FacultyEntity faculty = assignfacultyservice.findByPK(id);
		return new ResponseEntity<FacultyEntity>(faculty, HttpStatus.OK);
	}

	// creating get mapping through subjectName
	@GetMapping("/faculty/byName/{name}")
	public ResponseEntity<FacultyEntity> getFacultyByName(@PathVariable("name") String name)
			throws CourseNotFoundException {
		FacultyEntity faculty = assignfacultyservice.findByUserName(name);
		return new ResponseEntity<FacultyEntity>(faculty, HttpStatus.OK);
	}
}
