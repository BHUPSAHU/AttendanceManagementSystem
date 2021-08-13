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

import com.ams.entity.AssignFacultyEntity;
import com.ams.exception.RecordNotFoundException;
import com.ams.service.AssignFacultyServiceImpl;



@RestController
@RequestMapping(path = "/api")
public class AssignFacultyController {
	
	@Autowired
	AssignFacultyServiceImpl assignfacultyservice;
	
	@GetMapping("/faculty")
	public ResponseEntity<String> info(){
		String msg = "This path has Following URI services : ";
		ResponseEntity<String> str1 = new ResponseEntity<String>(msg,HttpStatus.OK);
		return str1;
	}

	@GetMapping("/faculty/all")
	public List<AssignFacultyEntity> getAllFaculty() throws RecordNotFoundException {
		return assignfacultyservice.findAllAssignFaculty();
	}

	@PostMapping(path = "/faculty/add")
	public ResponseEntity<Long> create(@RequestBody AssignFacultyEntity Assignfaculty) {
		long id = assignfacultyservice.add(Assignfaculty);
		ResponseEntity<Long> re = new ResponseEntity<Long>(id,HttpStatus.OK);
		return re;
	}

	@PutMapping("/faculty/update")
	public void update(@RequestBody AssignFacultyEntity faculty) throws Exception {
		assignfacultyservice.update(faculty);
	}

	@DeleteMapping("/faculty/delete")
	public void deleteAssignFaculty(@RequestBody AssignFacultyEntity assignfaculty) throws Exception {
		assignfacultyservice.delete(assignfaculty);
	}

	@GetMapping("/faculty/byId/{id}")
	public ResponseEntity<AssignFacultyEntity> getFacultyById(@PathVariable("id") Long id) throws Exception {
		AssignFacultyEntity faculty = assignfacultyservice.findByPK(id);
		return new ResponseEntity<AssignFacultyEntity>(faculty, HttpStatus.OK);
	}

	@GetMapping("/faculty/byName/{name}")
	public ResponseEntity<AssignFacultyEntity> getFacultyByName(@PathVariable("name") String name)
			throws RecordNotFoundException {
		AssignFacultyEntity faculty = assignfacultyservice.findByUserName(name);
		return new ResponseEntity<AssignFacultyEntity>(faculty, HttpStatus.OK);
	}
}
