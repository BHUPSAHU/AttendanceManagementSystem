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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ams.entity.StudentEntity;
import com.ams.service.StudentServiceImpl;



@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentServiceImpl studentService;

	@GetMapping("/student")
	public ResponseEntity<String> info() {
		String msg = "This path has Following URI services : ";
		ResponseEntity<String> str1 = new ResponseEntity<String>(msg, HttpStatus.OK);
		return str1;
	}
	
	@PostMapping("/student/add")
	public ResponseEntity<Long> addStudent(@RequestBody StudentEntity entity) {
		Long temp = studentService.add(entity);
		ResponseEntity<Long> responseEntity = new ResponseEntity<Long>(temp, HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/student/update")
	public void updateStudent(@RequestBody StudentEntity entity) throws Exception {
		studentService.update(entity);
	}

	@DeleteMapping("/student/delete")
	public void deleteStudent(@RequestBody StudentEntity entity) {
		studentService.delete(entity);
	}

	@GetMapping("/student/byName/{name}")
	public ResponseEntity<StudentEntity> findStudentByName(@PathVariable("name") String name) {
		StudentEntity temp = studentService.findByName(name);
		ResponseEntity<StudentEntity> responseEntity = new ResponseEntity<StudentEntity>(temp, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/student/byId/{id}")
	public ResponseEntity<StudentEntity> findStudentByPk(@PathVariable("id") long id) throws Exception {
		StudentEntity temp = studentService.findByPk(id);
		ResponseEntity<StudentEntity> responseEntity = new ResponseEntity<StudentEntity>(temp, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/student/all")
	public ResponseEntity<List<StudentEntity>> findAllStudents() {
		List<StudentEntity> tempList = studentService.findAllStudents();
		ResponseEntity<List<StudentEntity>> responseEntity = new ResponseEntity<List<StudentEntity>>(tempList,
				HttpStatus.OK);
		return responseEntity;
	}
}
