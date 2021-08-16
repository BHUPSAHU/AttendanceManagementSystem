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

import com.ams.entity.AttendanceEntity;
import com.ams.exception.ErrorDetails;
import com.ams.service.AttendanceService;


/**
 * @author Tejaswini
 *
 */
//mark class as controller
@RestController
@RequestMapping("/api")
public class AttendanceController {
	
	// @Autowire the AttendenceService class
	@Autowired
	AttendanceService attendanceService;

	@GetMapping("/attendance")
	public ResponseEntity<String> info() {
		String msg = "This path has Following URI services : ";
		ResponseEntity<String> str1 = new ResponseEntity<String>(msg, HttpStatus.OK);
		return str1;
	}
	// creating post mapping that adds to DB
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/attendance/add")
	public ResponseEntity<Long> addAttendance(@Valid @RequestBody AttendanceEntity ae , BindingResult result) {
		if(result.hasErrors()) {
			ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),result.getFieldErrors().stream().map(FieldError :: getDefaultMessage).collect(Collectors.toList()).toString() ,"ConstraintViolationException"); 
			return  new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);
			}
		long data = attendanceService.add(ae);
		ResponseEntity<Long> responseEntity = new ResponseEntity<Long>(data, HttpStatus.OK);
		return responseEntity;

	}
	// creating put mapping that update to DB
	@PutMapping("/attendance/update")
	public void updateAttendance(@RequestBody AttendanceEntity ae) throws Exception {

		attendanceService.update(ae);
	}
	// creating delete mapping that deletes on DB
	@DeleteMapping("/attendance/delete")
	public void deleteAttendance(@RequestBody AttendanceEntity ae) throws Exception {
		attendanceService.delete(ae);
	}
	// creating get mapping through attendance Name
	@GetMapping("/attendance/byName/{name}")
	public ResponseEntity<AttendanceEntity> findStudentByNmae(@PathVariable("name") String name) {
		AttendanceEntity ae = attendanceService.findByName(name);
		ResponseEntity<AttendanceEntity> responseEntity = new ResponseEntity<AttendanceEntity>(ae, HttpStatus.OK);
		return responseEntity;

	}
	// creating get mapping through attendance Id
	@GetMapping("/attendance/byId/{id}")
	public ResponseEntity<AttendanceEntity> findAttendenceByPk(@PathVariable("id") long id) throws Exception {
		AttendanceEntity ae = attendanceService.findByPk(id);
		ResponseEntity<AttendanceEntity> responseEntity = new ResponseEntity<AttendanceEntity>(ae, HttpStatus.OK);
		return responseEntity;

	}
	// fetch all subjects through Get mapping
	@GetMapping("/attendance/all")
	public ResponseEntity<List<AttendanceEntity>> findAllAttendances() {
		List<AttendanceEntity> aeList = attendanceService.findAllAttendances();
		ResponseEntity<List<AttendanceEntity>> responseEntity = new ResponseEntity<List<AttendanceEntity>>(aeList,
				HttpStatus.OK);
		return responseEntity;

	}

}
