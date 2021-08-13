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

import com.ams.entity.SubjectEntity;
import com.ams.service.SubjectServiceImpl;



@RestController
@RequestMapping("/api")
public class SubjectController {
	@Autowired
	SubjectServiceImpl subjectservice;
	
	@GetMapping("/subject")
	public ResponseEntity<String> info() {
		String msg = "This path has Following URI services : ";
		ResponseEntity<String> str1 = new ResponseEntity<String>(msg, HttpStatus.OK);
		return str1;
	}
	
	@PostMapping("/subject/add")
	public ResponseEntity<Long> addSubject( @RequestBody SubjectEntity subject)
	{
		long s1=subjectservice.add(subject);
		ResponseEntity<Long> re=new ResponseEntity<Long>(s1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping("/subject/update")
	public void updateSubject(@RequestBody SubjectEntity subject)throws Exception
	{
		subjectservice.update(subject);
		
	}
	
	@DeleteMapping("/subject/delete")
	public void deleteSubject(@RequestBody SubjectEntity subject)
	{
	subjectservice.delete(subject);
	}
	
	@GetMapping("/subject/byId/{id}")
	public ResponseEntity<SubjectEntity> findSubjectById(@PathVariable("id") long subjectId) throws Exception
	{
		SubjectEntity s1=subjectservice.findByPk(subjectId);
		ResponseEntity<SubjectEntity> re=new ResponseEntity<SubjectEntity>(s1,HttpStatus.OK);
		return re;
	}
	
	
	@GetMapping("/subject/byName/{name}")
	public ResponseEntity<SubjectEntity> findSubjectBySubjectName(@PathVariable("name") String subjectName)
	{
		SubjectEntity s1=subjectservice.findByName(subjectName);
		ResponseEntity<SubjectEntity> re=new ResponseEntity<SubjectEntity>(s1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/subject/all")
	public ResponseEntity<List<SubjectEntity>>findAllSubject()
	{
		List<SubjectEntity> list=subjectservice.findAllSubject();
		ResponseEntity<List<SubjectEntity>> re=new ResponseEntity<List<SubjectEntity>>(list,HttpStatus.OK);
		return re;
	}
}
