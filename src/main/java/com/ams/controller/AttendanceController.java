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

import com.ams.entity.AttendanceEntity;
import com.ams.service.AttendanceService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class AttendanceController {
	@Autowired
	AttendanceService attendanceService;

	@GetMapping("/attendance")
	public ResponseEntity<String> info() {
		String msg = "This path has Following URI services : ";
		ResponseEntity<String> str1 = new ResponseEntity<String>(msg, HttpStatus.OK);
		return str1;
	}

	@PostMapping("/attendance/add")
	public ResponseEntity<Long> addAttendance(@RequestBody AttendanceEntity ae) {
		long data = attendanceService.add(ae);
		ResponseEntity<Long> responseEntity = new ResponseEntity<Long>(data, HttpStatus.OK);
		return responseEntity;

	}

	@PutMapping("/attendance/update")
	public void updateAttendance(@RequestBody AttendanceEntity ae) throws Exception {

		attendanceService.update(ae);
	}

	@DeleteMapping("/attendance/delete")
	public void deleteAttendance(@RequestBody AttendanceEntity ae) throws Exception {
		attendanceService.delete(ae);
	}

	@GetMapping("/attendance/byName/{name}")
	public ResponseEntity<AttendanceEntity> findStudentByNmae(@PathVariable("name") String name) {
		AttendanceEntity ae = attendanceService.findByName(name);
		ResponseEntity<AttendanceEntity> responseEntity = new ResponseEntity<AttendanceEntity>(ae, HttpStatus.OK);
		return responseEntity;

	}

	@GetMapping("/attendance/byId/{id}")
	public ResponseEntity<AttendanceEntity> findAttendenceByPk(@PathVariable("id") long id) throws Exception {
		AttendanceEntity ae = attendanceService.findByPk(id);
		ResponseEntity<AttendanceEntity> responseEntity = new ResponseEntity<AttendanceEntity>(ae, HttpStatus.OK);
		return responseEntity;

	}

	@GetMapping("/attendance/all")
	public ResponseEntity<List<AttendanceEntity>> findAllAttendances() {
		List<AttendanceEntity> aeList = attendanceService.findAllAttendances();
		ResponseEntity<List<AttendanceEntity>> responseEntity = new ResponseEntity<List<AttendanceEntity>>(aeList,
				HttpStatus.OK);
		return responseEntity;

	}

}
