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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ams.entity.SubjectEntity;
import com.ams.exception.ErrorDetails;
import com.ams.service.SubjectServiceImpl;

/**
 * @author Arpitha S
 *
 */
//mark class as controller

@RestController
@RequestMapping("/api")
public class SubjectController {
	
	// @Autowire the SubjectService class
	@Autowired
	SubjectServiceImpl subjectservice;

	@GetMapping("/subject")
	public ResponseEntity<String> info() {
		String msg = "This path has Following URI services : ";
		ResponseEntity<String> str1 = new ResponseEntity<String>(msg, HttpStatus.OK);
		return str1;
	}

	// creating post mapping that adds to DB
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/subject/add")
	public ResponseEntity<Long> addSubject(@Valid @RequestBody SubjectEntity subject, BindingResult result) {
		if (result.hasErrors()) {
			ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), result.getFieldErrors().stream()
					.map(FieldError::getDefaultMessage).collect(Collectors.toList()).toString(),
					"ConstraintViolationException");
			return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
		}
		long s1 = subjectservice.add(subject);
		ResponseEntity<Long> re = new ResponseEntity<Long>(s1, HttpStatus.OK);
		return re;
	}

	// creating put mapping that update to DB
	@PutMapping("/subject/update")
	public void updateSubject(@RequestBody SubjectEntity subject) throws Exception {
		subjectservice.update(subject);

	}

	// creating delete mapping that deletes on DB
	@DeleteMapping("/subject/delete")
	public void deleteSubject(@RequestBody SubjectEntity subject) throws Exception {
		subjectservice.delete(subject);
	}

	// creating get mapping through subjectId
	@GetMapping("/subject/byId/{id}")
	public ResponseEntity<SubjectEntity> findSubjectById(@PathVariable("id") long subjectId) throws Exception {
		SubjectEntity s1 = subjectservice.findByPk(subjectId);
		ResponseEntity<SubjectEntity> re = new ResponseEntity<SubjectEntity>(s1, HttpStatus.OK);
		return re;
	}

	// creating get mapping through subjectName
	@GetMapping("/subject/byName/{name}")
	public ResponseEntity<SubjectEntity> findSubjectBySubjectName(@PathVariable("name") String subjectName) {
		SubjectEntity s1 = subjectservice.findByName(subjectName);
		ResponseEntity<SubjectEntity> re = new ResponseEntity<SubjectEntity>(s1, HttpStatus.OK);
		return re;
	}

	// fetch all subjects through Get mapping
	@GetMapping("/subject/all")
	public ResponseEntity<List<SubjectEntity>> findAllSubject() {
		List<SubjectEntity> list = subjectservice.findAllSubject();
		ResponseEntity<List<SubjectEntity>> re = new ResponseEntity<List<SubjectEntity>>(list, HttpStatus.OK);
		return re;
	}
}
