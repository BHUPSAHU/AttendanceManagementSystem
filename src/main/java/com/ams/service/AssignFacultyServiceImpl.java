package com.ams.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.entity.FacultyEntity;
import com.ams.exception.AssignFacultyNotFoundException;
import com.ams.repository.AssignFacultyDAO;

@Service
public class AssignFacultyServiceImpl implements AssignFacultyService {

	Supplier<Exception> s1 = () -> new AssignFacultyNotFoundException("Faculty Record Not Found in DataBase.");

	@Autowired
	AssignFacultyDAO repo;

	// getting all records by using method findAll()
	@Override
	public List<FacultyEntity> findAllAssignFaculty() {
		List<FacultyEntity> tempList = repo.findAll();
		return tempList;
	}

	// saving a specific record by using the method save()
	@Override
	public long add(FacultyEntity entity) {
		FacultyEntity temp = repo.save(entity);
		return temp.getFacultyid();
	}

	// updating a record
	@Override
	public void update(FacultyEntity entity) throws Exception {
		long id = entity.getFacultyid();
		FacultyEntity temp = repo.findById(id).orElseThrow(s1);
		temp.setUserName(entity.getUserName());
		temp.setTotalClass(entity.getTotalClass());
		temp.setSubjectList(entity.getSubjectList());
		repo.save(temp);
	}

	// deleting a specific record by using the method deleteById()
	@Override
	public void delete(FacultyEntity assignfaculty) throws Exception {
		FacultyEntity temp = repo.findById(assignfaculty.getFacultyid()).orElseThrow(s1);
		repo.deleteById(temp.getFacultyid());
	}

	// getting a specific record by using the method findByName()
	@Override
	public FacultyEntity findByUserName(String name) {
		FacultyEntity temp = repo.findByUserName(name);
		return temp;
	}

	// getting a specific record by using the method findById()
	@Override
	public FacultyEntity findByPK(long id) throws Exception {
		FacultyEntity temp = repo.findById(id).orElseThrow(s1);
		return temp;
	}

}
