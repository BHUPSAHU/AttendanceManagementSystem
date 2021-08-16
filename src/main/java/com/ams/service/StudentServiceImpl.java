package com.ams.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.entity.StudentEntity;
import com.ams.exception.StudentNotFoundException;
import com.ams.repository.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDAO repo;

	// Exception suppliers
	static Supplier<Exception> sup1 = () -> new StudentNotFoundException("Student is not present in the database");

	// saving a specific record by using the method save()
	@Override
	public long add(StudentEntity entity) {
		entity.setName(entity.getFirstName(), entity.getLastName());
		StudentEntity temp = repo.save(entity);
		return temp.getStudentId();
	}
	// updating a record
	@Override
	public StudentEntity update(StudentEntity entity) throws Exception {
		long id = entity.getStudentId();
		StudentEntity temp = repo.findById(id).orElseThrow(sup1);
		temp.setRollNo(entity.getRollNo());
		temp.setFirstName(entity.getFirstName());
		temp.setLastName(entity.getLastName());
		temp.setDob(entity.getDob());
		temp.setGender(entity.getGender());
		temp.setMobileNo(entity.getMobileNo());
		temp.setCourseId(entity.getCourseId());
		temp.setCourseName(entity.getCourseName());
		temp.setEmailId(entity.getEmailId());
		temp.setFatherEmailId(entity.getFatherEmailId());
		temp.setFatherMobileNo(entity.getFatherMobileNo());
		temp.setProfilePic(entity.getProfilePic());
		temp.setName(entity.getFirstName(), entity.getLastName());
		repo.save(temp);
		return temp;
	}
	// deleting a specific record by using the method deleteById()
	@Override
	public void delete(StudentEntity entity) {
		repo.deleteById(entity.getStudentId());
	}
	// getting a specific record by using the method findByName()
	@Override
	public StudentEntity findByName(String name) {
		StudentEntity temp = repo.findByName(name);
		return temp;
	}
	// getting a specific record by using the method findById()
	@Override
	public StudentEntity findByPk(long id) throws Exception {
		StudentEntity temp = repo.findById(id).orElseThrow(sup1);
		return temp;
	}
	// getting all records by using method findAll()
	@Override
	public List<StudentEntity> findAllStudents() {
		List<StudentEntity> tempList = repo.findAll();
		return tempList;
	}
}
